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
public interface FileIO {
    
        void WriteData();


        default void CreateNewAcc(String TFusername){
        ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
   
        System.out.println(TFusername);
        JSONObject obj = new JSONObject();
        obj.put("Name", TFusername);
        obj.put("Author", "App Shah");
        JSONArray company = new JSONArray();
        company.put("Company: Facebook");
        company.put("Company: PayPal");
        company.put("Company: Google");
        obj.put("Company List", company);
        arr.add(obj);
        arr.add(obj);
        System.out.println(obj);
        
try {
    
      
    
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write("[\n");
      for(int i=0;i<arr.size();i++){
        myWriter.write(arr.get(i).toString());
        myWriter.write(",\n");

      }
      myWriter.write("]");

      myWriter.close();
      System.out.println("Successfully wrote to the file.");


      String content = Files.readString(Paths.get("filename.txt"));

    JSONArray array = new JSONArray(content);  
    for(int i=0; i < array.length(); i++)   
    {  
    JSONObject object = array.getJSONObject(i);  
    System.out.println(object.getString("Author"));
    System.out.println(object.getJSONArray("Company List"));
    // System.out.println(object.getString("Name"));  
    }
 




  



    } catch (IOException e) {

      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    
    
    
}

