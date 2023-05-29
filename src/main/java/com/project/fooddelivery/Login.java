
package com.project.fooddelivery;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        setIconImage(new ImageIcon("icons\\icon.png").getImage());
        FoodDelivery.user = null; // Will Contain user data after login.
        this.setTitle("Login");
        initComponents(); // init GUI.
        setLocationRelativeTo(null); // To show page in the middle.
        
        TFusername.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { 
            }

            @Override
            public void keyReleased(KeyEvent e) {  
            }
        //********To Login by using enter key ***********//
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                LOGIN();
                }
            }
        });
        
        
        TFpassword.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            //********To Login by using enter key ***********//
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                LOGIN();
                }
            }
        });

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lusername = new javax.swing.JLabel();
        TFusername = new javax.swing.JTextField();
        Lpassword = new javax.swing.JLabel();
        TFpassword = new javax.swing.JPasswordField();
        Blogin = new javax.swing.JButton();
        Lnewacc = new javax.swing.JLabel();
        Bnewacc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Lusername.setText("User Name:");

        Lpassword.setText("Password:");

        Blogin.setText("Login");
        Blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloginActionPerformed(evt);
            }
        });

        Lnewacc.setText("Or create new account");

        Bnewacc.setText("Create New Account");
        Bnewacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnewaccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lusername)
                        .addGap(18, 18, 18)
                        .addComponent(TFusername, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lnewacc)
                        .addGap(18, 18, 18)
                        .addComponent(Bnewacc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Lpassword)
                        .addGap(18, 18, 18)
                        .addComponent(TFpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(Blogin)))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lusername)
                    .addComponent(TFusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lpassword)
                    .addComponent(TFpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(Blogin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lnewacc)
                    .addComponent(Bnewacc))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//******** Method to validate user credintals ***********//
    private void LOGIN(){
        User user = new User(TFusername.getText(),TFpassword.getText()); // Create object of user with entered data
        if(user.ValidateUser()){
            //******** Success Login ***********//
        FoodDelivery.user = user;
        if(FoodDelivery.user.getPermission() == 1){
            OrdersForm JOrdersForm = new OrdersForm();
            JOrdersForm.setVisible(true);
            Point Location = new Point(this.getLocationOnScreen().x,1);
            JOrdersForm.setLocation(Location);
        }else{
        RestaurantForm JRestaurantForm = new RestaurantForm(); // View restaurant form.
        JRestaurantForm.setVisible(true);
        Point Location = new Point(this.getLocationOnScreen().x,1);
        JRestaurantForm.setLocation(Location);
        
        }
        this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Incorrect username or password",
            "Failed", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    
    private void BloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloginActionPerformed
        LOGIN();
    }//GEN-LAST:event_BloginActionPerformed

    private void BnewaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnewaccActionPerformed
        //********Show create account page ***********//
        AccountCreation JframeAcc = new AccountCreation();
        JframeAcc.setVisible(true);
        JframeAcc.setLocation(this.getLocationOnScreen());
        this.setVisible(false);
        
       
        
        
    }//GEN-LAST:event_BnewaccActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Blogin;
    private javax.swing.JButton Bnewacc;
    private javax.swing.JLabel Lnewacc;
    private javax.swing.JLabel Lpassword;
    private javax.swing.JLabel Lusername;
    private javax.swing.JPasswordField TFpassword;
    private javax.swing.JTextField TFusername;
    // End of variables declaration//GEN-END:variables
}
