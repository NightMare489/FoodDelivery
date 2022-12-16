
package com.project.fooddelivery;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject; 


public class User {
    private String Name,password,Email,PhoneNumber;
    private CreditCard creditCard;
    private Cart cart = new Cart();
    private Orders orders = new Orders();
    public Cart getCart() {
        return cart;
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

    public User(String Name, String password, String Email,String PhoneNumber,CreditCard creditCard) {
        this.Name = Name;
        this.password = password;
        this.creditCard = creditCard;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
    }

    public User(String Name, String password) {
        this.Name = Name;
        this.password = password;
    }

    public Orders getOrders() {
        return orders;
    }


    public void UpdateUser(){
        
        try {
            String content = Files.readString(Paths.get("Users.txt"));
            FileWriter Writer = new FileWriter("Users.txt");
            Writer.write("[\n");
            JSONArray array = new JSONArray(content);  
            for(int i=0; i < array.length(); i++)   
            {  
            JSONObject object = array.getJSONObject(i);
                if(object.getString("Name").equals(this.Name)){
                    JSONObject obj = new JSONObject();
                    JSONArray CreditCardArray = creditCard.MakeJSONarray();
                    JSONArray CartArray = cart.MakeJSONarray();
                    JSONArray OrdersArray = orders.MakeJSONarray();
                    obj.put("Name", Name);
                    obj.put("Password", password);
                    obj.put("Email", Email);
                    obj.put("PhoneNumber", PhoneNumber);
                    obj.put("CreditCard", CreditCardArray);
                    obj.put("Cart", CartArray);
                    obj.put("Orders",OrdersArray);
                    
                    
                    Writer.write(obj.toString());
                    Writer.write(",\n");

                }else{   
                        Writer.write(array.getJSONObject(i).toString());
                        Writer.write(",\n");
                }
                
            }
             
            Writer.write("]");
            Writer.close();

        }catch (IOException e) {
    
        }

    }
        

    public boolean ValidateUser(){
        try{
            String content = Files.readString(Paths.get("Users.txt"));
    
            JSONArray array = new JSONArray(content);  
            for(int i=0; i < array.length(); i++)   
            {  
            JSONObject object = array.getJSONObject(i);

            
                if(object.getString("Name").equals(this.Name) && object.getString("Password").equals(this.password) ){           
                    creditCard = new CreditCard().makeCreditCardFromArray(object.getJSONArray("CreditCard"));
                    Email = object.getString("Email");
                    PhoneNumber = object.getString("PhoneNumber");
                    cart.makeCartFromArray(object.getJSONArray("Cart"));
                    orders.makeOrdersFromArray(object.getJSONArray("Orders"));
                    
                    return true;
                }
            }
            return false;
        }catch (IOException e) {
            return false;
        }

    }

    public String RegisterUser(){
        try {
            String content = Files.readString(Paths.get("Users.txt"));
    
            JSONArray array = new JSONArray(content);  
            for(int i=0; i < array.length(); i++)   
            {  
            JSONObject object = array.getJSONObject(i);
                if(object.getString("Name").equals(this.Name)){
                    return "User name already exists";
                }
                if(object.getString("Email").equals(this.Email)){
                    return "This Email is used before";
                }
            }
             FileWriter Writer = new FileWriter("Users.txt");
            Writer.write("[\n");
            for(int i=0;i<array.length();i++){
              Writer.write(array.getJSONObject(i).toString());
              Writer.write(",\n");
      
            }



            JSONObject obj = new JSONObject();
            JSONArray CreditCardArray = creditCard.MakeJSONarray();
            JSONArray Cart = new JSONArray();
            JSONArray Orders = new JSONArray();
            
            obj.put("Name", Name);
            obj.put("Password", password);
            obj.put("Email", Email);
            obj.put("PhoneNumber", PhoneNumber);
            obj.put("CreditCard", CreditCardArray);
            obj.put("Cart", Cart);
            obj.put("Orders", Orders);

            Writer.write(obj.toString());
            Writer.write("]");
            Writer.close();
    
        }catch (IOException e) {
    
        }


        return "Account registered successfully";
    }


    
}
