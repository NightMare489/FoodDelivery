
package com.project.fooddelivery;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import data.RoutingService;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

public class Cart {
  private  ArrayList<Dish> cart = new ArrayList();
  private  ArrayList<Message> Messages = new ArrayList();

  private int Status=0;
  private String User = FoodDelivery.user == null ? "":FoodDelivery.user.getName();
  private String Address = FoodDelivery.user == null ? "":FoodDelivery.user.getAddress();
  private double lat = FoodDelivery.user == null ? 0.0:FoodDelivery.user.getLat();
  private double lon = FoodDelivery.user == null ? 0.0:FoodDelivery.user.getLon();
  


  
  public Cart(){
      
  }
  //******** To solve refrence object problem ***********//
    public Cart(Cart c){
      this.Address= c.Address;
      this.lat = c.lat;
      this.lon = c.lon;
      this.cart = (ArrayList<Dish>)c.cart.clone();
      
  }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAddress() {
        return Address;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }



    
    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }
  
    
      public void AddtoCart(Dish d){  
        cart.add(d);     
    }
      
      public void AddtoMessages(Message m){
          Messages.add(m);
          UpdateCart();
      }
      
    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
      
    
    public String getDeliveryFees(){
        RoutingService.getInstance().routing(24.089015072633437, 32.89867204002298, lat, lon);
            
        return String.format("%.2f", ((RoutingService.getInstance().getDistance()/1000.0) * 5.0));
    
    
    }
    
  public String getSubTotal(){
      double DSubTotal=0;
      String SSubTotal="";
        for(int i=0; i < cart.size(); i++)   {          
            DSubTotal+=Double.parseDouble(cart.get(i).getPrice());                      
        }
      SSubTotal += DSubTotal;

    return SSubTotal;
  }
  
 public String getTotal(){
     String T = getSubTotal();
     double DTotalPrice = Double.parseDouble(T) + Double.parseDouble(getDeliveryFees());        
      return String.format("%.2f", (DTotalPrice));
  }
 
 public String getVAT(){
     String SSubTotal = getSubTotal();
     double DSubTotal = Double.parseDouble(SSubTotal);
     return String.format("%.2f", (DSubTotal * 0.14));
     
 }
//******** Write all users data to file ***********//
 
    private void UpdateCart(){
        
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
        Document filter = new Document("Name", FoodDelivery.user.getName());
        Document update = new Document("$set", new Document("Cart", MakeCartarray()));
        collection.updateOne(filter, update);
    }
 
 
    public void AddAndSavetoCart(Dish d){  
        cart.add(d);
        UpdateCart();

            
    }
    
      public void ClearCart(){  
        cart.clear();
        UpdateCart();     
    }
    
    
    
    public void RemoveFromCartAndSave(Dish d){
        cart.remove(d);
        UpdateCart();
    }

    public ArrayList<Dish> getCartArray() {
        return cart;
    }
    
    public ArrayList<Message> getMessageArray(){
        return Messages;
    } 
    
    //******** To convert JSON Objects to cart data ***********//
    public void makeCartFromArray(List<Document> arr){
        
        for(Document doc : arr){       
            Dish d = new Dish(doc.getString("Name"),doc.getString("desc"),doc.getString("Price"));
            cart.add(d); 
        }
        
      
    }
    
    public void makeMessagesFromArray(List<Document> arr){
        
        for(Document doc : arr){
            Message m = new Message(doc.getString("From"),doc.getString("Title"),doc.getString("Data"));
            Messages.add(m); 
        }
        
      
    }
    
    
    //******** To convert cart data to JSON Objects ***********//
public ArrayList<Document> MakeCartarray(){
        ArrayList<Document> CartArray = new ArrayList<Document>();
       
        for(int i=0;i<cart.size();i++){
          Document doc = new Document();
          doc.append("Name", cart.get(i).getName());
          doc.append("desc", cart.get(i).getDesc());
          doc.append("Price", cart.get(i).getPrice());
          CartArray.add(doc);
          
        }
       
        return CartArray;
    }
    
 
public ArrayList<Document> MakeMessagesArray(){
        ArrayList<Document> MessagesArray = new ArrayList<Document>();
       
        for(int i=0;i<Messages.size();i++){
          Document doc = new Document();
          doc.append("From", Messages.get(i).getFrom());
          doc.append("Title", Messages.get(i).getTitle());
          doc.append("Data", Messages.get(i).getData());
          MessagesArray.add(doc);
          
        }
       
        return MessagesArray;
    }
    
    
    
}
