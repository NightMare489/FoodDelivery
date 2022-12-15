/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.fooddelivery;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject; 

/**
 *
 * @author TheUltimateGamer
 */

 //subclass cart implements credit
public class User implements FileIO {
    private String Name,password,Email,PhoneNumber;
    private CreditCard creditCard;
    private Cart cart = new Cart();

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


    public void WriteData(){
       
    }

    public void UpdateUser(){
        
        try {
            String content = Files.readString(Paths.get("Users.txt"));
            FileWriter myWriter = new FileWriter("Users.txt");
            myWriter.write("[\n");
            JSONArray array = new JSONArray(content);  
            for(int i=0; i < array.length(); i++)   
            {  
            JSONObject object = array.getJSONObject(i);
                if(object.getString("Name").equals(this.Name)){
                    JSONObject obj = new JSONObject();
                    JSONArray CreditCardArray = creditCard.MakeJSONarray();
                    JSONArray CartArray = cart.MakeJSONarray();

                    obj.put("Name", Name);
                    obj.put("Password", password);
                    obj.put("Email", Email);
                    obj.put("PhoneNumber", PhoneNumber);
                    obj.put("CreditCard", CreditCardArray);
                    obj.put("Cart", CartArray);
                    
                    
                    myWriter.write(obj.toString());
                    myWriter.write(",\n");

                }else{   
                        myWriter.write(array.getJSONObject(i).toString());
                        myWriter.write(",\n");
                }
                
            }
             
            myWriter.write("]");
            myWriter.close();
            



            

    
        }catch (IOException e) {
    
        }


        
    }
        
    
    
    
    
    public boolean ValidateUser(){
        try{
            String content = Files.readString(Paths.get("Users.txt"));
    System.out.println(content);
            JSONArray array = new JSONArray(content);  
            for(int i=0; i < array.length(); i++)   
            {  
            JSONObject object = array.getJSONObject(i);
                System.out.println(object.getString("Name"));
                System.out.println(object.getString("Password"));
            
                if(object.getString("Name").equals(this.Name) && object.getString("Password").equals(this.password) ){           
                    creditCard = new CreditCard().makeCreditCardFromArray(object.getJSONArray("CreditCard"));
                    Email = object.getString("Email");
                    PhoneNumber = object.getString("PhoneNumber");
                    cart.makeCartFromArray(object.getJSONArray("Cart"));
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
             FileWriter myWriter = new FileWriter("Users.txt");
            myWriter.write("[\n");
            for(int i=0;i<array.length();i++){
              myWriter.write(array.getJSONObject(i).toString());
              myWriter.write(",\n");
      
            }



            JSONObject obj = new JSONObject();
            JSONArray CreditCardArray = creditCard.MakeJSONarray();
            JSONArray Cart = new JSONArray();

            obj.put("Name", Name);
            obj.put("Password", password);
            obj.put("Email", Email);
            obj.put("PhoneNumber", PhoneNumber);
            obj.put("CreditCard", CreditCardArray);
            obj.put("Cart", Cart);

            myWriter.write(obj.toString());
            myWriter.write("]");
            myWriter.close();
    
        }catch (IOException e) {
    
        }


        return "Account registered successfully";
    }


    
}
