package com.project.fooddelivery;
public class Restaurant {
    private String name,Rate,desc,time;

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
