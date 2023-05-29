
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONObject;

public class RestaurantForm extends javax.swing.JFrame  implements ActionListener{

       private JMenuItem Order_History, My_Cart, Log_Out,My_Profile;  
    public RestaurantForm() {
        initComponents();
        setIconImage(new ImageIcon("icons\\icon.png").getImage());
         JMenu menu;
         
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("☰");  
          
          Order_History=new JMenuItem("Order History");  
          My_Cart=new JMenuItem("My Cart");  
          Log_Out=new JMenuItem("Logout");
          My_Profile = new JMenuItem("My Profile");
          
 
          Log_Out.addActionListener(this);   
          My_Profile.addActionListener(this);
          
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
          menu.add(Log_Out);  
          mb.add(menu);
          mb.add(new JLabel(" |  "));
          mb.add(new JLabel(FoodDelivery.user.getName()));
          
          this.setJMenuBar(mb);   


        final int FRAME_WIDTH = 555;
        final int FRAME_HEIGHT = 810;

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Restaurants");
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

try{
        MongoCollection<Document> collection = MongoDB.Database.getCollection("Resturants");
        FindIterable<Document> documents = collection.find();
        for(Document doc : documents){
            
        Restaurant Res = new Restaurant(doc.getString("Name"), doc.getString("Rate"), doc.getString("Desc"), doc.getString("Time"));
        JPanel sp2 = new RestaurantPanel(this,Res);

        p2.add(sp2);
            
        }
        int st;
        if(FoodDelivery.user.getPermission() ==0){
        JPanel sp3 = new AddRestaurantPanel();
        p2.add(sp3);
        st = 6;
        }else{
            st = 7;
        }

        
        
        
        //-------------------------
        int length = documents.into(new ArrayList<>()).size();
        
        for(int i=0;i<st-length;i++){
            JPanel sp1 = new RestaurantPanel(false);
            p2.add(sp1);
        }

    }catch (Exception e) {
            System.out.println(e);
    }


        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {  
       if(e.getSource() == Order_History){
            OrdersForm of = new OrdersForm();
            of.setVisible(true);
            of.setLocation(getLocationOnScreen());
            setVisible(false);
       }
        
        
        if(e.getSource()==Log_Out) {
        Login JframeLogin = new Login();
        JframeLogin.setVisible(true);
        JframeLogin.setLocation(this.getLocationOnScreen());
        this.setVisible(false);
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
