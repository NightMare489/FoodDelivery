/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.fooddelivery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author TheUltimateGamer
 */

 //super
public class Cart {
  private  ArrayList<Dish> cart = new ArrayList();

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
    
    
    public void makeCartFromArray(JSONArray arr){
        
        for(int i=0;i<arr.length();i++){
            
            String s = "[" + arr.get(i).toString() + "]"; 
            JSONArray array = new JSONArray(s);
            JSONObject object = array.getJSONObject(0);         
            Dish d = new Dish(object.getString("Name"),object.getString("desc"),object.getString("Price"));
            cart.add(d); 
        }
        
       

    }
    
    
    
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
