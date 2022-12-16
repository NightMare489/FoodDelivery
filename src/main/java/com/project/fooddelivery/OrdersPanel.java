
package com.project.fooddelivery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;


public class OrdersPanel extends javax.swing.JPanel  {
    private javax.swing.JLabel Icon;
    private javax.swing.JLabel Order_Num;
    private javax.swing.JLabel Items_Num;
    private javax.swing.JLabel Price;

    
    private javax.swing.JFrame frame;
    private Cart c;
    private int Number;
    
    
    public OrdersPanel(javax.swing.JFrame frame,Cart c , int Number){
        this.frame = frame;
        this.c = c;
        this.Number = Number;
        initComponents();
        
    }


    
    private void initComponents() {
        
        setPreferredSize(new Dimension(0, 105));
     
        Icon = new javax.swing.JLabel();
        Order_Num = new javax.swing.JLabel();
        Items_Num = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        


        Icon.setIcon(new javax.swing.ImageIcon("icons\\Checkout.png")); 

        Order_Num.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        Order_Num.setText("Order #"+Number);

        Items_Num.setText("Items: " + c.getCartArray().size());

        Price.setText("Total: "+ c.getTotal()+" EGP");

            this.setBorder(new LineBorder(Color.black));
            
            addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                     CartForm cf = new CartForm(c,2);
                     cf.setVisible(true);
                     cf.setLocation(frame.getLocationOnScreen());
                     frame.setVisible(false);

                }
            });
            
            
      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
        setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Order_Num, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Items_Num, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 94, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Icon)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Order_Num)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Items_Num)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Price)
                            )))
                .addGap(10, 10, 10))
        );
      
    }  
    
}
