
package com.project.fooddelivery;

import java.util.ArrayList;
import org.json.JSONArray;

public class Orders {
    private  ArrayList<Cart> Orders = new ArrayList();

    public ArrayList<Cart> getOrders() {
        return Orders;
    }
    
    
    
    
    public void AddAndSavetoOrders(Cart jsn){ 
        Orders.add(new Cart(jsn)); 
        FoodDelivery.user.UpdateUser();      
    }
    
    
    public void makeOrdersFromArray(JSONArray arr){
        for(int i=0;i<arr.length();i++){
            
            String s = "[" + arr.get(i).toString() + "]"; 
            JSONArray array = new JSONArray(s);
            
            for(int j=0;j<array.length();j++){
                String x = array.get(j).toString();
                JSONArray array2 = new JSONArray(x);
                Cart c = new Cart();
                c.makeCartFromArray(array2);
                Orders.add(c);
            }                     
        }
    }
    
    
    
    public JSONArray MakeJSONarray(){
        JSONArray OrdersArray = new JSONArray();
       
        for(int i=0;i<Orders.size();i++){
          OrdersArray.put(Orders.get(i).MakeJSONarray());        
        }
 
        return OrdersArray;
    }
    
    
    
}
