/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.fooddelivery;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
public class MongoDB {
    static MongoDatabase Database;
    static MongoClient mongoClient;
   public MongoDB(){
        String connectionString = "mongodb+srv://yasershaban:P6tBBmVXcQi9Eyoi@cluster0.wx9nhg3.mongodb.net/?retryWrites=true&w=majority";
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build();
                mongoClient = MongoClients.create(settings);
                Database = mongoClient.getDatabase("FoodDelievery");  
    }
}