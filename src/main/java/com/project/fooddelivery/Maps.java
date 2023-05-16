/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.fooddelivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.jxmapviewer.viewer.GeoPosition;

/**
 *
 * @author TheUltimateGamer
 */
public class Maps {
   
       private static final String API_KEY = "1lJawuIWxWluHgiCHAOeo1WhGgcZP3vU";
       
       
       public String getGeoLocationInfo(double Latitude,double Longitude){
        GeoPosition coordinates = new GeoPosition(Latitude, Longitude);
        return ExtractInfo(reverseGeocode(coordinates));
       }
       
       
       
       private String ExtractInfo(String json){
           
        org.json.JSONObject jsonObject = new org.json.JSONObject(json);
        JSONArray resultsArray = jsonObject.getJSONArray("results");
        String s = "";

        if (resultsArray.length() > 0) {
            org.json.JSONObject locationObject = resultsArray.getJSONObject(0).getJSONArray("locations").getJSONObject(0);
            
            String street = locationObject.getString("street");
            String adminArea6 = locationObject.getString("adminArea6");
            String adminArea5 = locationObject.getString("adminArea5");
            String adminArea4 = locationObject.getString("adminArea4");
            
            s+= street + " , " +adminArea6 + " , " +  adminArea5 + " , " + adminArea4;
        }
        return s;

    }


    private String reverseGeocode(GeoPosition coordinates) {
        try {
            String encodedCoordinates = URLEncoder.encode(coordinates.getLatitude() + "," + coordinates.getLongitude(), "UTF-8");
            String url = "https://www.mapquestapi.com/geocoding/v1/reverse?key=" + API_KEY + "&location=" + encodedCoordinates;
            
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),StandardCharsets.UTF_8));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                
                return response.toString(); 
            } else {

                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
