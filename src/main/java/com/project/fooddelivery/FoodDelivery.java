
package com.project.fooddelivery;

public class FoodDelivery {
    //******** hold current loged in user information ***********//
    public static User user;
    public static MongoDB db;
    
        public static void main(String[] args) {
        //********Show Login Page ***********//
        
        db = new MongoDB();
        new Login().setVisible(true); 

    }
}
