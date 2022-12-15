/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.project.fooddelivery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author EL-YaMaMa
 */
public class CartForm extends javax.swing.JFrame implements ActionListener {
JMenuItem i1, i2, i3, i4, i5,i6,back;  
JMenu username;
// JLabel back;
    /**
     * Creates new form DishesForm
     */


    public CartForm() {
        initComponents();
        
        JMenu menu, submenu; 
        
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("☰");  
          submenu=new JMenu("Sub Menu");  
          i1=new JMenuItem("Order History");  
          i2=new JMenuItem("My Cart");  
          i3=new JMenuItem("Logout"); 
          i6 = new JMenuItem("My Profile");
          
          i1.addActionListener(this);  
          i3.addActionListener(this);   
          i6.addActionListener(this);
          

          
          menu.add(i6);menu.add(i1); menu.add(i2); menu.add(i3);  
//          submenu.add(i4); submenu.add(i5);  
//          menu.add(submenu); 
//          menu.add(submenu);  
          username =  new JMenu(FoodDelivery.user.getName());
          back =  new JMenuItem("←");
          back.setMinimumSize(menu.getSize());
          back.setPreferredSize(menu.getSize());
          back.setMaximumSize(new Dimension(20, 20));
          back.addActionListener(this);


          mb.add(back);
          mb.add(menu);
          mb.add(new JLabel(" | "));
          mb.add(username);
          
          
          
          this.setJMenuBar(mb);     

//---------------------------


        final int FRAME_WIDTH = 555;
        final int FRAME_HEIGHT = 810;

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dishes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        JPanel p2 = new JPanel();


        p2.setLayout(new GridLayout(-1, 1));
        p2.setBackground(Color.LIGHT_GRAY);
        // p2.setPreferredSize(new Dimension(950, 800));
        p2.setAutoscrolls(true);

        JScrollPane scrollPane = new JScrollPane(p2);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setBounds(0, 0, 950, 800);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(540, 740));
        contentPane.add(scrollPane, BorderLayout.CENTER);


          ArrayList<Dish> dishes =  FoodDelivery.user.getCart().getCartArray();
            
            
            
            for(int i=0; i < dishes.size(); i++)   
            {  
 
           
          JPanel sp1 = new DishesPanel(this,dishes.get(i));
                                       p2.add(sp1);

                    
                    
                
            }
            
            
            
            for(int i=0;i<6-dishes.size();i++){
            JPanel sp1 = new RestaurantPanel(false);
            p2.add(sp1);
        }
           
            
        
        this.add(contentPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }




    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource()==i3) {
        Login JframeLogin = new Login();
        JframeLogin.setVisible(true);
        JframeLogin.setLocation(this.getLocationOnScreen());
        this.setVisible(false);
        }

        if(e.getSource()==back) {
            RestaurantForm jframeRestaurantForm = new RestaurantForm();
            jframeRestaurantForm.setVisible(true);
            jframeRestaurantForm.setLocation(getLocationOnScreen());
            setVisible(false);
        }
        
        if(e.getSource() == i6){
            AccountFrame Acc = new AccountFrame();
            Acc.setVisible(true);
            Acc.setLocation(getLocationOnScreen());
            setVisible(false);
        }

        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    private javax.swing.JMenu jMenu1;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
