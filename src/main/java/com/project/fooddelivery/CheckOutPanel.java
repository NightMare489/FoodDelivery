
package com.project.fooddelivery;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class CheckOutPanel extends javax.swing.JPanel  {
    private javax.swing.JButton Action_Button;
    private javax.swing.JLabel Sub_Total_Label;
    private javax.swing.JLabel Total_Label;
    private javax.swing.JLabel Delivery_Fees;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel VAT;
    private javax.swing.JLabel Sub_Total;
    private javax.swing.JLabel Delivery_Fees_Label;
    
    
    private javax.swing.JFrame frame;
    private Cart c;
    private int state;
    public CheckOutPanel(javax.swing.JFrame frame , Cart c , int state){
        this.c = c;
        this.frame = frame;
        this.state = state;
    initComponents();
    }



    
    private void initComponents() {
        
        setPreferredSize(new Dimension(0, 105));
        this.setBorder(new LineBorder(Color.black));
        Sub_Total_Label = new javax.swing.JLabel();
        Action_Button = new javax.swing.JButton();
        Sub_Total = new javax.swing.JLabel();
        Delivery_Fees_Label = new javax.swing.JLabel();
        Total_Label = new javax.swing.JLabel();
        Delivery_Fees = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        VAT = new javax.swing.JLabel();
        Sub_Total_Label.setText("Sub Total:");

        if(state == 2){
            Action_Button.hide();
        
        }else{
        
        Action_Button.setBackground(new java.awt.Color(102, 102, 102));
        Action_Button.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 12));
        Action_Button.setForeground(new java.awt.Color(255, 255, 255));
        Action_Button.setText("Checkout");
        
        Action_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodDelivery.user.getOrders().AddAndSavetoOrders(FoodDelivery.user.getCart());
                JOptionPane.showMessageDialog(frame, "Order Confirmed",
                "Success", JOptionPane.INFORMATION_MESSAGE);
                FoodDelivery.user.getCart().ClearCart();
                CartForm cf = new CartForm(FoodDelivery.user.getCart(),state);
                cf.setVisible(true);
                cf.setLocation(frame.getLocationOnScreen());
                frame.setVisible(false);
                

                
                
            }
        });
        }
        Sub_Total.setText( c.getSubTotal() +" EGP");

        Delivery_Fees_Label.setText("Delivery Fees: ");

        Total_Label.setFont(new java.awt.Font("Segoe UI", 1, 18));
        Total_Label.setText("Total: ");

        Delivery_Fees.setText("20 EGP");

        Total.setFont(new java.awt.Font("Segoe UI", 1, 14));
        
        Total.setText(c.getTotal()+" EGP");

        VAT.setFont(new java.awt.Font("Segoe UI", 1, 10));
        VAT.setText("Inclusive of VAT 14% i.e. "+ c.getVAT() +" EGP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
        setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sub_Total_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delivery_Fees_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Total_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Sub_Total)
                                    .addComponent(Delivery_Fees, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(162, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(Action_Button)
                                .addGap(21, 21, 21))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(VAT)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Sub_Total_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Delivery_Fees_Label))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Sub_Total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Delivery_Fees)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VAT)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Action_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Total))
                        .addGap(10, 10, 10))))
        );

    }
    
    
    
    
}
