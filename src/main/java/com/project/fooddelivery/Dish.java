
package com.project.fooddelivery;

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
 
}
