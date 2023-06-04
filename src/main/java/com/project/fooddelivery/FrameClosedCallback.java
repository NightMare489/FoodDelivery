/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.fooddelivery;

/**
 *
 * @author TheUltimateGamer
 */
public interface FrameClosedCallback {
    void onFrameClosed(String data);
    void onFrameClosed(String Address,double lat,double lon);
}
