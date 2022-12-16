
package com.project.fooddelivery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class DishesPanel extends javax.swing.JPanel  {
    
    
  
    private javax.swing.JLabel Icon;
    private javax.swing.JLabel Dish_Name;
    private javax.swing.JLabel Dish_Description;
    private javax.swing.JLabel Dish_Price;
    private javax.swing.JButton Action_Button;

    
    private javax.swing.JFrame frame;
    private Dish dish;
    private int state;
    
    private String ResName;
    public DishesPanel(javax.swing.JFrame frame,Dish dish , int state){
        this.dish = dish;
        this.frame = frame;
        this.state = state;
        initComponents();
        
    }
    

   
    private void initComponents() {
        
        setPreferredSize(new Dimension(0, 105));
       
        Icon = new javax.swing.JLabel();
        Dish_Name = new javax.swing.JLabel();
        Dish_Description = new javax.swing.JLabel();
        Dish_Price = new javax.swing.JLabel();
        Action_Button = new javax.swing.JButton();

        Icon.setIcon(new javax.swing.ImageIcon("icons\\" + dish.getName() + ".png")); 

        Dish_Name.setFont(new java.awt.Font("Segoe UI", 0, 24));
        Dish_Name.setText(dish.getName());

        Dish_Description.setText(dish.getDesc());

        Dish_Price.setText(dish.getPrice() + " EGP");

        if(state == 2){
            Action_Button.hide();
        }
        
        
        if(state ==0){
        Action_Button.setText("Add to Cart");
        }else if(state == 1){
        Action_Button.setText("Remove");
        }
        
        Action_Button.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            
            if(state ==0){
               FoodDelivery.user.getCart().AddAndSavetoCart(dish);
            }else if(state==1){
            FoodDelivery.user.getCart().RemoveFromCartAndSave(dish);
            
            CartForm cf = new CartForm(FoodDelivery.user.getCart(),1);
            cf.setVisible(true);
            cf.setLocation(frame.getLocationOnScreen());
            frame.setVisible(false);
            
            
            }
        } 
      } );
    
            this.setBorder(new LineBorder(Color.black));


            
            
          
            
            
      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
        setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Dish_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Action_Button))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Dish_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Dish_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Icon)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Dish_Name)
                            .addComponent(Action_Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Dish_Description)))
                .addComponent(Dish_Price)
            )
        );

        
 
        
        
        
        
      
               
            
     
        
      
    } 
    
    
    
    
}
