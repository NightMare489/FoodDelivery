/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.fooddelivery;

/**
 *
 * @author TheUltimateGamer
 */
public class Message {
    private String From,data,title;
    

    public String getFrom() {
        return From;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    

    public Message(String From,String title,String Data) {
        this.From = From;   
        this.data = Data;
        this.title = title;
    }
    
    
    
    
    
}
