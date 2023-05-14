
package com.project.fooddelivery;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

public class Cart {
  private  ArrayList<Dish> cart = new ArrayList();
  
  public Cart(){
      
  }
  //******** To solve refrence object problem ***********//
    public Cart(Cart c){
      
      this.cart = (ArrayList<Dish>)c.cart.clone();
      
  }
  
      public void AddtoCart(Dish d){  
        cart.add(d);     
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
     String STotalPRice = "";
     String T = getSubTotal();
     double DTotalPrice = Double.parseDouble(T) + 20.0;
     STotalPRice += DTotalPrice;
            
      return STotalPRice;
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
    
    //******** To convert JSON Objects to cart data ***********//
    public void makeCartFromArray(List<Document> arr){
        
        for(Document doc : arr){       
            Dish d = new Dish(doc.getString("Name"),doc.getString("desc"),doc.getString("Price"));
            cart.add(d); 
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
    
 
    
    
}
