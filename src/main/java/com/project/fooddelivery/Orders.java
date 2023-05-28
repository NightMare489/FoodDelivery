
package com.project.fooddelivery;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;

public class Orders {
    private  ArrayList<Cart> Orders = new ArrayList();
    
    public ArrayList<Cart> getOrders() {
        return Orders;
    }

    
    public void UpdateOrders(){
        Orders.clear();
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");

        if(FoodDelivery.user.getPermission()==2){
        

                Bson filter = Filters.and(
                Filters.eq("Name", FoodDelivery.user.getName())
            );     
            FindIterable<Document> documents = collection.find(filter);        
            List<Document> Orderss = (List<Document>) documents.first().get("Orders");     
            for(Document order:Orderss){
            makeOrdersFromArray2(order);
            }
        }else{
            FindIterable<Document> AllCarts = collection.find();
                for(Document d : AllCarts){
                List<Document> ct = (List<Document>) d.get("Orders");     

                    for(Document order:ct){
                    makeOrdersFromArray2(order);
             }
            }
        }
    }
    
    
    public void DeleteAndSaveOrder(Cart c){
        Orders.get(Orders.indexOf(c)).setStatus(-1);
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
        Document filter = new Document("Name", FoodDelivery.user.getName());
        Document update = new Document("$set", new Document("Orders", MakeOrdersDocument()));
        collection.updateOne(filter, update);
        
    }
    
    
    
    public void AddAndSavetoOrders(Cart jsn){ 
        Orders.add(new Cart(jsn)); 
        
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
        Document filter = new Document("Name", FoodDelivery.user.getName());
        Document update = new Document("$set", new Document("Orders", MakeOrdersDocument()));
        collection.updateOne(filter, update);
        
        FoodDelivery.user.UpdateUser();      
    }
    
    
    public void makeOrdersFromArray(List<Document> arr){
        for(Document doc : arr){ 
                Cart c = new Cart();
                c.makeCartFromArray((List<Document>) doc.get("Arr", Document.class));
                c.setStatus(doc.getInteger("Status"));
                Orders.add(c);
                
            }                    
    }
    
    public void makeOrdersFromArray2(Document doc){

                Cart c = new Cart();
                c.setStatus(doc.getInteger("Status"));
                c.setUser(doc.getString("Name"));
        

                c.makeCartFromArray((List<Document>) doc.get("Arr", new ArrayList().getClass()));
                Orders.add(c);
                
            
    }
    
    
    
    public ArrayList<Document> MakeOrdersDocument(){
        ArrayList<Document> OrdersArray = new ArrayList<Document>();
        
        
       
        for(int i=0;i<Orders.size();i++){
           Document doc = new Document("Status", Orders.get(i).getStatus()).append("Name", Orders.get(i).getUser())
                   .append("Arr", Orders.get(i).MakeCartarray());
            
          OrdersArray.add(doc);        
        }
 
        return OrdersArray;
    }
    
    
    
}
