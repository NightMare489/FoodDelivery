
package com.project.fooddelivery;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Dish {
    String name ,desc,Price;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return Price;
    }

    public Dish(String name, String desc, String Price) {
        this.name = name;
        this.desc = desc;
        this.Price = Price;
    }
    
    public void AddDishToRestaurant(String Resname){
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Resturants");
        Document filter = new Document("Name", Resname);
        Document doc = new Document("Name" , this.name)
                .append("desc", this.desc)
                .append("Price", this.Price);
        
        Document update = new Document("$push", new Document("Dishes", doc));
        collection.updateOne(filter, update);
        
        
    }
    
    public void RemoveDishFromRestaurant(String Resname){
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Resturants");
        Document filter = new Document("Name", Resname);
        Document doc = new Document("Name" , this.name)
                .append("desc", this.desc)
                .append("Price", this.Price);
        
        Document update = new Document("$pull", new Document("Dishes", doc));
        collection.updateOne(filter, update);
        
        
    }
 
}
