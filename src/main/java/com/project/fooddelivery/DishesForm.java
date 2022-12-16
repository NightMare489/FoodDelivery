
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.json.JSONArray;
import org.json.JSONObject;


public class DishesForm extends javax.swing.JFrame implements ActionListener {
private JMenuItem Order_History, My_Cart, Logout,My_Profile,back;  

    public DishesForm(String ResName,int state) {
        
        initComponents();
        JMenu menu; 
        
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("☰");   
          Order_History=new JMenuItem("Order History");  
          My_Cart=new JMenuItem("My Cart");  
          Logout=new JMenuItem("Logout"); 
          My_Profile = new JMenuItem("My Profile");
          
          Order_History.addActionListener(this);  
          My_Cart.addActionListener(this);
          Logout.addActionListener(this);   
          My_Profile.addActionListener(this);
          

          
          menu.add(My_Profile);
          menu.add(Order_History);
          menu.add(My_Cart);
          menu.add(Logout);  
          
          back =  new JMenuItem("←");
          back.setMinimumSize(menu.getSize());
          back.setPreferredSize(menu.getSize());
          back.setMaximumSize(new Dimension(20, 20));
          back.addActionListener(this);


         mb.add(back);
         mb.add(menu);
         mb.add(new JLabel(" |  "));
         mb.add(new JLabel(FoodDelivery.user.getName()));
          
         this.setJMenuBar(mb);     

        final int FRAME_WIDTH = 555;
        final int FRAME_HEIGHT = 810;

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dishes");
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
        //******** take dishes content from resturent file objects ***********//
            try{
            String content = Files.readString(Paths.get("Restaurant.txt"));
    
            JSONArray array = new JSONArray(content); 
            int numDishes=0;
            for(int i=0; i < array.length(); i++)   
            {  
            JSONObject object = array.getJSONObject(i);
            
                if(object.getString("Name").equals(ResName)){ 
                  JSONArray arr=  object.getJSONArray("Dishes");
                  numDishes = arr.length();
                    for(int j=0;j<arr.length();j++){
                        String ob = "[";
                        ob +=arr.get(j).toString();
                        ob += "]";
                        JSONObject JSobj = new JSONArray(ob).getJSONObject(0);
                        Dish dish = new Dish(JSobj.getString("Name"),JSobj.getString("desc"),JSobj.getString("Price"));
                           JPanel sp1 = new DishesPanel(this,dish,state);
                                       p2.add(sp1);
                    }
                    
                }
            }

            for(int i=0;i<7-numDishes;i++){
            JPanel sp1 = new RestaurantPanel(false);
            p2.add(sp1);
        }
           
        }catch (IOException e) {
            
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
        if(e.getSource()==Logout) {
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
        
                    if(e.getSource() == My_Cart){
            CartForm cf = new CartForm(FoodDelivery.user.getCart(),1);
            cf.setVisible(true);
            cf.setLocation(getLocationOnScreen());
            setVisible(false);
                    }
        
        if(e.getSource() == My_Profile){
            AccountFrame Acc = new AccountFrame();
            Acc.setVisible(true);
            Acc.setLocation(getLocationOnScreen());
            setVisible(false);
        }

    }

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
