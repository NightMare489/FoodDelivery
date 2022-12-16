
package com.project.fooddelivery;
import java.util.ArrayList;
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
    public void AddAndSavetoCart(Dish d){  
        cart.add(d); 
        FoodDelivery.user.UpdateUser();      
    }
    
      public void ClearCart(){  
        cart.clear();
        FoodDelivery.user.UpdateUser();      
    }
    
    
    
    public void RemoveFromCartAndSave(Dish d){
        cart.remove(d);
        FoodDelivery.user.UpdateUser();   
    }

    public ArrayList<Dish> getCartArray() {
        return cart;
    }
    
    //******** To convert JSON Objects to cart data ***********//
    public void makeCartFromArray(JSONArray arr){
        
        for(int i=0;i<arr.length();i++){
            
            String s = "[" + arr.get(i).toString() + "]"; 
            JSONArray array = new JSONArray(s);
            JSONObject object = array.getJSONObject(0);         
            Dish d = new Dish(object.getString("Name"),object.getString("desc"),object.getString("Price"));
            cart.add(d); 
        }
        
       

    }
    
    
    //******** To convert cart data to JSON Objects ***********//
public JSONArray MakeJSONarray(){
        JSONArray CartArray = new JSONArray();
       
        for(int i=0;i<cart.size();i++){
          JSONObject obj = new JSONObject();
          obj.put("Name", cart.get(i).getName());
          obj.put("desc", cart.get(i).getDesc());
          obj.put("Price", cart.get(i).getPrice());
          CartArray.put(obj);
          
        }
       
        return CartArray;
    }
    
 
    
    
}
