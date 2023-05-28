
package com.project.fooddelivery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OrdersForm extends javax.swing.JFrame  implements ActionListener{

   private JMenuItem Order_History, My_Cart, Logout, i4, i5,My_Profile,back;  

    public OrdersForm() {
        initComponents();
        FoodDelivery.user.getOrders().UpdateOrders();
        
         JMenu menu, submenu,username;  
 
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("☰");  
          submenu=new JMenu("Sub Menu");  
          Order_History=new JMenuItem("Order History");  
          My_Cart=new JMenuItem("My Cart");  
          Logout=new JMenuItem("Logout");
          My_Profile = new JMenuItem("My Profile");
          menu.add(My_Profile); 

          if(FoodDelivery.user.getPermission() == 2){
          Order_History.addActionListener(this);  
          My_Cart.addActionListener(this);
          menu.add(Order_History);
          menu.add(My_Cart);
          }
          if(FoodDelivery.user.getPermission() == 0){
              Order_History.addActionListener(this); 
              menu.add(Order_History);
          }
          
          
          Logout.addActionListener(this);   
          My_Profile.addActionListener(this);
          
          if(FoodDelivery.user.getPermission() != 1){
          back =  new JMenuItem("←");
          back.setMinimumSize(menu.getSize());
          back.setPreferredSize(menu.getSize());
          back.setMaximumSize(new Dimension(20, 20));
          back.addActionListener(this);
          mb.add(back);

          }
          

          menu.add(Logout);
          mb.add(menu);
          mb.add(new JLabel(" |  "));
          mb.add(new JLabel(FoodDelivery.user.getName()));
  
        this.setJMenuBar(mb);   

        final int FRAME_WIDTH = 555;
        final int FRAME_HEIGHT = 810;

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Orders");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
  
        JPanel p2 = new JPanel();


        p2.setLayout(new GridLayout(-1, 1));
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setAutoscrolls(true);

        JScrollPane scrollPane = new JScrollPane(p2);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(540, 740));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        ArrayList<Cart> od = FoodDelivery.user.getOrders().getOrders();
        
        for(int i=0; i < od.size(); i++)   
        {  
        
        JPanel sp1 = new OrdersPanel(this,od.get(i),i+1);
        p2.add(sp1);
        }

        for(int i=0;i<7-od.size();i++){
            JPanel sp1 = new RestaurantPanel(false);
            p2.add(sp1);
        }



        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource()==Logout) {
          
        Login JframeLogin = new Login();
        JframeLogin.setVisible(true);
        JframeLogin.setLocation(this.getLocationOnScreen());
        this.setVisible(false);
        }
        if(e.getSource()==back) {
            
            if(FoodDelivery.user.getPermission() ==1){
                
            }
            else{
            RestaurantForm jframeRestaurantForm = new RestaurantForm();
            jframeRestaurantForm.setVisible(true);
            jframeRestaurantForm.setLocation(getLocationOnScreen());
            setVisible(false);
            }
        }
        if(e.getSource() == My_Profile){
            AccountFrame Acc = new AccountFrame();
            Acc.setVisible(true);
            Acc.setLocation(getLocationOnScreen());
            setVisible(false);
        }
            if(e.getSource() == My_Cart){
            CartForm cf = new CartForm(FoodDelivery.user.getCart(),1);
            cf.setVisible(true);
            cf.setLocation(getLocationOnScreen());
            setVisible(false);
        }
}     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

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
            .addGap(0, 317, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
