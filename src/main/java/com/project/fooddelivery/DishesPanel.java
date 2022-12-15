/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.fooddelivery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author EL-YaMaMa
 */
public class DishesPanel extends javax.swing.JPanel  {
    
    
  
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jButton1;
    // private javax.swing.JPanel jPanel1;
    
    private javax.swing.JFrame frame;
    private Dish dish;
    private boolean isCart;
    
    private String ResName;
    public DishesPanel(javax.swing.JFrame frame,Dish dish , boolean isCart){
        this.dish = dish;
        this.frame = frame;
        this.isCart = isCart;
        initComponents();
        
    }
    

   
    private void initComponents() {
        
        setPreferredSize(new Dimension(0, 105));
        
        

        // jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon("icons\\" + dish.getName() + ".png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText(dish.getName());

        jLabel3.setText(dish.getDesc());

        jLabel5.setText(dish.getPrice() + " EGP");

        
        if(!isCart){
        jButton1.setText("Add to Cart");
        }else{
        jButton1.setText("Remove");
        }
        
        jButton1.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            
            if(!isCart){
               FoodDelivery.user.getCart().AddAndSavetoCart(dish);
            }else{
            FoodDelivery.user.getCart().RemoveFromCartAndSave(dish);
            
            CartForm cf = new CartForm();
            cf.setVisible(true);
            cf.setLocation(frame.getLocationOnScreen());
            frame.setVisible(false);
            
            
            }
        } 
      } );
    
      
            // sp1.setPreferredSize(new Dimension(900, 180));
            this.setBorder(new LineBorder(Color.black));


            
            
          
            
            
      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
        setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addComponent(jLabel5)
            )//.addGap(14, 14, 14))
        );

        
 
        
        
        
        
      
               
            
     
        
      
    }// </editor-fold>  
    
    
    
    
}
