
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
    
    public static void UpdateMessages(Message m,Cart c){
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
        ArrayList<Document> arr = c.MakeCartarray();
        Document doc1 = new Document("Status", c.getStatus())
        .append("Name", c.getUser())
        .append("Address", c.getAddress())
        .append("lat", c.getLat())
        .append("lon", c.getLon())
        .append("Arr", c.MakeCartarray())
        .append("Messages", c.MakeMessagesArray());
        c.AddtoMessages(m);
        Document doc2 = new Document("Status", c.getStatus())
        .append("Name", c.getUser())
        .append("Address", c.getAddress())
        .append("lat", c.getLat())
        .append("lon", c.getLon())
        .append("Arr", c.MakeCartarray())
        .append("Messages", c.MakeMessagesArray());
        
        // Create the filter to match the document with the given UserName and old value
        Document filter = new Document("Name", c.getUser())
                .append("Orders", doc1);

        // Create the update query to set the new value using the positional operator $
        Document updateQuery = new Document("$set", new Document()
                .append("Orders.$", doc2));
        
        collection.updateOne(filter, updateQuery);
        
    
        
    }
    
    
    
    public static void ChangeOrderStatus(int newStatus,Cart c){
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
//        Document filter = new Document("Name", c.getUser());
        ArrayList<Document> arr = c.MakeCartarray();
        Document doc1 = new Document("Status", c.getStatus())
        .append("Name", c.getUser())
        .append("Address", c.getAddress())
        .append("lat", c.getLat())
        .append("lon", c.getLon())
        .append("Arr", c.MakeCartarray())
        .append("Messages", c.MakeMessagesArray());
        c.setStatus(newStatus);
        Document doc2 = new Document("Status", c.getStatus())
        .append("Name", c.getUser())
                        .append("Address", c.getAddress())
        .append("lat", c.getLat())
        .append("lon", c.getLon())
        .append("Arr", c.MakeCartarray())
        .append("Messages", c.MakeMessagesArray());
        
        // Create the filter to match the document with the given UserName and old value
        Document filter = new Document("Name", c.getUser())
                .append("Orders", doc1);

        // Create the update query to set the new value using the positional operator $
        Document updateQuery = new Document("$set", new Document()
                .append("Orders.$", doc2));
        
        collection.updateOne(filter, updateQuery);
    
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
                c.setAddress(doc.getString("Address"));
                c.setLat(doc.getDouble("lat"));
                c.setLon(doc.getDouble("lon"));
                c.makeMessagesFromArray((List<Document>) doc.get("Messages", Document.class));
                c.setStatus(doc.getInteger("Status"));
                Orders.add(c);
                
            }                    
    }
    
    public void makeOrdersFromArray2(Document doc){

                Cart c = new Cart();
                c.setStatus(doc.getInteger("Status"));
                c.setUser(doc.getString("Name"));
                c.setAddress(doc.getString("Address"));
                c.setLat(doc.getDouble("lat"));
                c.setLon(doc.getDouble("lon"));
                c.makeCartFromArray((List<Document>) doc.get("Arr", new ArrayList().getClass()));
                c.makeMessagesFromArray((List<Document>) doc.get("Messages", new ArrayList().getClass()));
                Orders.add(c);
                
            
    }
    
    
    
    public ArrayList<Document> MakeOrdersDocument(){
        ArrayList<Document> OrdersArray = new ArrayList<Document>();
        
        
       
        for(int i=0;i<Orders.size();i++){
           Document doc = new Document("Status", Orders.get(i).getStatus())
                   .append("Name", Orders.get(i).getUser())
                   .append("Address", Orders.get(i).getAddress())
                   .append("lat", Orders.get(i).getLat())
                   .append("lon", Orders.get(i).getLon())
                   .append("Arr", Orders.get(i).MakeCartarray())
                   .append("Messages", Orders.get(i).MakeMessagesArray());
            
          OrdersArray.add(doc);        
        }
 
        return OrdersArray;
    }
    
    
    
}
