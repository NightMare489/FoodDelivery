package com.project.fooddelivery;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import org.bson.Document;

public class Restaurant {
    private String name,Rate,desc,time;
    
    public void SaveRestaurant(){
    MongoCollection<Document> collection = MongoDB.Database.getCollection("Resturants");
    
                Document doc = new Document("Name", this.name)
                  .append("Dishes", new ArrayList<Document>())
                  .append("Rate", "0.0")
                  .append("Desc", this.desc)
                  .append("Time", this.time);
                collection.insertOne(doc);
    
    
    }

    public String getTime() {
        return time;
    }

    public String getDesc() {
        return desc;
    }

    public String getRate() {
        return Rate;
    }

    public String getName() {
        return name;
    }

    public Restaurant(String name,String Rate,String desc,String time){
        this.name = name;
        this.Rate = Rate;
        this.desc = desc;
        this.time = time;    
    }



}
