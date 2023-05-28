
package com.project.fooddelivery;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONObject; 


public class User {
    private String Name,password,Email,Address,PhoneNumber;
    private int Permission;
    private CreditCard creditCard;
    private Cart cart = new Cart();
    private Orders orders = new Orders();
    public Cart getCart() {
        return cart;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    
    

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public User(String Name, String password, String Email,String Address,String PhoneNumber,CreditCard creditCard, int Permission) {
        this.Name = Name;
        this.password = password;
        this.creditCard = creditCard;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Permission = Permission;
    }

    public User(String Name, String password) {
        this.Name = Name;
        this.password = password;
    }

    public Orders getOrders() {
        return orders;
    }

    public int getPermission() {
        return Permission;
    }

    public void setPermission(int Permission) {
        this.Permission = Permission;
    }
    


    public void UpdateUser(){
        //******** update data of user  ***********//
        try {
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
        Document filter = new Document("Name", getName());
        Document update = new Document("$set", new Document("Password",getPassword()));
        collection.updateOne(filter, update);

        }catch (Exception e) {
    
        }

    }
    
        

    public boolean ValidateUser(){
        try{
            //******** chaeck when login to validate user ***********//
            
            
            Bson filter = Filters.and(
                Filters.eq("Name", this.Name),
                Filters.eq("Password", this.password)
            );
            
            MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
            FindIterable<Document> documents = collection.find(filter);
            
            if(documents.iterator().hasNext()){
                Email = documents.first().getString("Email");
                PhoneNumber = documents.first().getString("PhoneNumber");
                Address = documents.first().getString("Address");
                Permission = documents.first().getInteger("Permission");
                creditCard = new CreditCard().makeCreditCardFromObject(documents.first().get("CreditCard", Document.class));
                List<Document> Cart = (List<Document>) documents.first().get("Cart");     
                cart.makeCartFromArray(Cart);
                
                if(Permission ==0){
                    FindIterable<Document> AllCarts = collection.find();
                        for(Document d : AllCarts){
                        List<Document> ct = (List<Document>) d.get("Orders");     
                        
                            for(Document order:ct){
                            orders.makeOrdersFromArray2(order);
                            }
                    }
          
                }else{
                
                List<Document> Orders = (List<Document>) documents.first().get("Orders");
                
                for(Document order:Orders){
                orders.makeOrdersFromArray2(order);
                }
              }
     
                return true;
            }
            
            return false;
        }catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public String RegisterUser(){
        try {
            Document query = new Document("Name", this.Name);
            MongoCollection<Document> collection = MongoDB.Database.getCollection("Users");
            FindIterable<Document> documents = collection.find(query);
            
            
            if(documents.iterator().hasNext())
                return "User name already exists";
            query = new Document("Email", this.Email);
            documents = collection.find(query);
            if(documents.iterator().hasNext())
                return "This Email is used before";

            

            Document CreditCardObj = creditCard.MakeDocument();

            

            Document doc = new Document("Name", this.Name)
                  .append("Password", password)
                  .append("Email", Email)
                  .append("PhoneNumber", PhoneNumber)
                  .append("Address", Address)
                  .append("Permission", Permission)
                  .append("CreditCard",CreditCardObj)
                  .append("Cart",new ArrayList<Document>())
                  .append("Orders",new ArrayList<Document>());

                    // Get a reference to the "users" collection
                // Insert the document into the collection
                collection.insertOne(doc);
            
           
    
        }catch (Exception e) {
               return "Unexpected Error Occured";
        }
        return "Account registered successfully";
    }


    
}
