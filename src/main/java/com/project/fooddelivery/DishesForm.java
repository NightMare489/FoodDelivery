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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author EL-YaMaMa
 */
public class DishesForm extends javax.swing.JFrame implements ActionListener {
JMenuItem i1, i2, i3, i4, i5;  
JMenu username;
JLabel back;
    /**
     * Creates new form DishesForm
     */

private String ResName="";

    public DishesForm(String ResName) {
        initComponents();
        this.ResName = ResName;
        
        JMenu menu, submenu; 
        
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("☰");  
          submenu=new JMenu("Sub Menu");  
          i1=new JMenuItem("Order History");  
          i2=new JMenuItem("My Favourites");  
          i3=new JMenuItem("Logout");  
          
          i1.addActionListener(this);  
          i3.addActionListener(this);   

          
          menu.add(i1); menu.add(i2); menu.add(i3);  
//          submenu.add(i4); submenu.add(i5);  
//          menu.add(submenu); 
//          menu.add(submenu);  
          username =  new JMenu(FoodDelivery.user.getName());
          back =  new JLabel("←");
          //back.addActionListener(this);
//                    username =  new JMenu("TEST");


          mb.add(menu);
          mb.add(new JLabel(" | "));
          mb.add(username);
          mb.add(i1);
          
          
          this.setJMenuBar(mb);   
          this.setVisible(true);  

//---------------------------


        final int FRAME_WIDTH = 555;
        final int FRAME_HEIGHT = 800;

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dishes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
//        this.setTitle("home libaray");

        // Top Panel
//        JPanel p1 = new JPanel();
//        p1.setLayout(new FlowLayout());
//        p1.setBackground(Color.LIGHT_GRAY);
//        p1.setPreferredSize(new Dimension(950, 100));
//
//        JLabel l1 = new JLabel("All Library Items");
//        l1.setForeground(Color.BLACK);
//        l1.setPreferredSize(new Dimension(900, 50));
//        l1.setFont(l1.getFont().deriveFont(30.0f));
//
//        p1.add(l1);

        // Content Panel
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
        contentPane.setPreferredSize(new Dimension(540, 905));
        contentPane.add(scrollPane, BorderLayout.CENTER);


            Color[] c = {Color.RED,Color.GREEN,Color.BLUE};
            
            try{
            String content = Files.readString(Paths.get("Restaurant.txt"));
    
            JSONArray array = new JSONArray(content);  
            for(int i=0; i < array.length(); i++)   
            {  
            JSONObject object = array.getJSONObject(i);
                if(object.getString("Name").equals(ResName)){ 
                  JSONArray arr=  object.getJSONArray("Dishes");
                    for(int j=0;j<arr.length();j++){
                           JPanel sp1 = new DishesPanel(this,arr.getString(j));
                                       p2.add(sp1);

                    }
   
//                    System.out.println();
                    
                }
            }
           
        }catch (IOException e) {
            
        }
            
            
//        for (int i = 0; i < 10; i++) {
//
//            
//
//
//
//
//        }

        // contentPane.add(p2);
//        contentPane.add(p1, BorderLayout.NORTH);
        // frame.add(p2);
        // frame.setContentPane(contentPane);
        this.add(contentPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource()==i3) {
            System.out.println("yes");
        Login JframeLogin = new Login();
        JframeLogin.setVisible(true);
        JframeLogin.setLocation(this.getLocationOnScreen());
        this.setVisible(false);
        }
        if(e.getSource() == back){
            System.out.println("welp");


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
