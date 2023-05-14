
package com.project.fooddelivery;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.json.JSONArray;

public class Orders {
    private  ArrayList<Cart> Orders = new ArrayList();

    public ArrayList<Cart> getOrders() {
        return Orders;
    }
    
    public void AddAndSavetoOrders(Cart jsn){ 
        Orders.add(new Cart(jsn)); 
        
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
        Document filter = new Document("Name", FoodDelivery.user.getName());
        Document update = new Document("$set", new Document("Orders", MakeOrdersarray()));
        collection.updateOne(filter, update);
        
        FoodDelivery.user.UpdateUser();      
    }
    
    
    public void makeOrdersFromArray(List<Document> arr){
        for(Document doc : arr){ 
                Cart c = new Cart();
                c.makeCartFromArray((List<Document>) doc);
                Orders.add(c);
            }                    
    }
    
    public void makeOrdersFromArray2(List<Document> arr){
                Cart c = new Cart();
                c.makeCartFromArray((List<Document>) arr);
                Orders.add(c);
    }
    
    
    
    public ArrayList<ArrayList<Document>> MakeOrdersarray(){
        ArrayList<ArrayList<Document>> OrdersArray = new ArrayList<ArrayList<Document>>();
       
        for(int i=0;i<Orders.size();i++){
            
          OrdersArray.add(Orders.get(i).MakeCartarray());        
        }
 
        return OrdersArray;
    }
    
    
    
}
