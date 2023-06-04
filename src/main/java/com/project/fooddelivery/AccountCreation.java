package com.project.fooddelivery;

import java.text.NumberFormat;
import java.time.Year;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;

public class AccountCreation extends javax.swing.JFrame implements FrameClosedCallback {
        double Lat=0.0,Lon=0.0;

    public AccountCreation() {
        initComponents(); // Show GUI
        this.setTitle("Create Account");
        setIconImage(new ImageIcon("icons\\icon.png").getImage());
        //********To make year accept only integers between next year and 10 more years ***********//
        NumberFormat YearFormat = new  java.text.DecimalFormat("#0");
        NumberFormatter YearFormatter = new NumberFormatter(YearFormat);

        YearFormatter.setValueClass(Integer.class);
        YearFormatter.setMinimum(Year.now().getValue()+1);
        YearFormatter.setMaximum(Year.now().getValue()+10);
        TFexpYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(YearFormatter));


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TFCCV = new javax.swing.JFormattedTextField();
        LCCV = new javax.swing.JLabel();
        LCardNumber = new javax.swing.JLabel();
        TFCardnumber = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        TFexpMonth = new javax.swing.JFormattedTextField();
        LexpMonth = new javax.swing.JLabel();
        TFexpYear = new javax.swing.JFormattedTextField();
        LexpYear = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TFusername = new javax.swing.JTextField();
        LUsername = new javax.swing.JLabel();
        LPassword = new javax.swing.JLabel();
        TFEmail = new javax.swing.JTextField();
        LEmail = new javax.swing.JLabel();
        TFpassword = new javax.swing.JPasswordField();
        TFphonenumber = new javax.swing.JFormattedTextField();
        LPhonenumber = new javax.swing.JLabel();
        LAddress = new javax.swing.JLabel();
        TFAddress = new javax.swing.JTextField();
        AddressSelection = new javax.swing.JButton();
        BCreate = new javax.swing.JButton();
        BbackLogin = new javax.swing.JButton();
        PermissionChkbx = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Credit Card Info"));

        try {
            TFCCV.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        LCCV.setText("CCV:");

        LCardNumber.setText("Card Number:");

        try {
            TFCardnumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Expire Date"));

        TFexpMonth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM"))));

        LexpMonth.setText("Month:");

        TFexpYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        LexpYear.setText("Year:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(LexpMonth)
                        .addGap(18, 18, 18)
                        .addComponent(TFexpMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(LexpYear)
                        .addGap(18, 18, 18)
                        .addComponent(TFexpYear, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFexpMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LexpMonth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFexpYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LexpYear))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LCardNumber)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(LCCV)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFCardnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCCV, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFCardnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LCardNumber))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFCCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LCCV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("User Info"));

        LUsername.setText("User Name:");

        LPassword.setText("Password");

        LEmail.setText("Email:");

        try {
            TFphonenumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        LPhonenumber.setText("Phone Number:");

        LAddress.setText("Addess:");

        TFAddress.setEditable(false);

        AddressSelection.setText("Choose");
        AddressSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressSelectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LUsername)
                    .addComponent(LEmail)
                    .addComponent(LPassword)
                    .addComponent(LPhonenumber)
                    .addComponent(LAddress))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFusername, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TFphonenumber)
                        .addComponent(TFEmail)
                        .addComponent(TFpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TFAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddressSelection)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LUsername)
                    .addComponent(TFusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPassword)
                    .addComponent(TFpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LEmail)
                    .addComponent(TFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPhonenumber)
                    .addComponent(TFphonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LAddress)
                    .addComponent(AddressSelection))
                .addContainerGap())
        );

        BCreate.setText("Create");
        BCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCreateActionPerformed(evt);
            }
        });

        BbackLogin.setText("Back to login");
        BbackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BbackLoginActionPerformed(evt);
            }
        });

        PermissionChkbx.setText("Apply For a Job");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BbackLogin)
                        .addGap(70, 70, 70)
                        .addComponent(BCreate)
                        .addGap(144, 144, 144))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PermissionChkbx)
                        .addGap(222, 222, 222))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PermissionChkbx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCreate)
                    .addComponent(BbackLogin))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BbackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BbackLoginActionPerformed
        //********Go back to login ***********//
        Login JframeLogin = new Login();
        JframeLogin.setVisible(true);
        JframeLogin.setLocation(this.getLocationOnScreen());
        this.setVisible(false);


    }//GEN-LAST:event_BbackLoginActionPerformed

    private void AddressSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressSelectionActionPerformed
        
        MapForm JframeMap = new MapForm(this,0);
        JframeMap.setVisible(true);
        JframeMap.setLocation(this.getLocationOnScreen());
        
    }//GEN-LAST:event_AddressSelectionActionPerformed

//********To remove - between phone number and credit card number ***********//
    private String ParseMask(String s){
        String out="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='-'){
                out += s.charAt(i);
            }
        }
        return out;
    }

    private void BCreateActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String errMsg="";
        String username = TFusername.getText();
        String Email = TFEmail.getText();
        String password = TFpassword.getText();
        String Address = TFAddress.getText();

        String PhoneNumber = ParseMask(TFphonenumber.getText());
        String cardnumber = ParseMask(TFCardnumber.getText());
        String CCV = TFCCV.getText();
        String expMonth = TFexpMonth.getText();
        String expYear = TFexpYear.getText();
        
        int permission = PermissionChkbx.isSelected()? 1 : 2;



        if(username.isEmpty()){
            errMsg = "User name can't be empty";
        }else if(password.isEmpty()){
            errMsg = "Password can't be empty";
        }else if(Email.isEmpty()){
            errMsg = "Email can't be empty";
        }else if(PhoneNumber.isEmpty()){
            errMsg = "Phone number can't be empty";
        }else if (Address.isEmpty()){
            errMsg = "Address can't be empty";
        }  
        else if(cardnumber.isEmpty()){
            errMsg = "Card number can't be empty";
        }else if (CCV.isEmpty()){
            errMsg = "CCV can't be empty";
        }else if(expMonth.isEmpty()){
            errMsg = "Expire month can't be empty";
        }else if(expYear.isEmpty()){
            errMsg = "Expire year can't be empty";
        }

        if(!errMsg.isEmpty()){
            JOptionPane.showMessageDialog(this, errMsg,
            "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //********create new credit card from entered data ***********//
        CreditCard creditCard = new CreditCard(cardnumber, CCV, expMonth, expYear);
        User user = new User(username,password,Email,Address,Lat,Lon,PhoneNumber,creditCard,permission);
        String RegStatus = user.RegisterUser(); // Check if register was successful and isn't in the database
        if(RegStatus.equals("Account registered successfully")){
            JOptionPane.showMessageDialog(this, RegStatus,
            "Success", JOptionPane.INFORMATION_MESSAGE);
            
            //********return to login page after successful regestration***********//
        Login JframeLogin = new Login();
        JframeLogin.setVisible(true);
        JframeLogin.setLocation(this.getLocationOnScreen());
        this.setVisible(false);
            
            
        }else{
            JOptionPane.showMessageDialog(this, RegStatus,
            "Failed", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddressSelection;
    private javax.swing.JButton BCreate;
    private javax.swing.JButton BbackLogin;
    private javax.swing.JLabel LAddress;
    private javax.swing.JLabel LCCV;
    private javax.swing.JLabel LCardNumber;
    private javax.swing.JLabel LEmail;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel LPhonenumber;
    private javax.swing.JLabel LUsername;
    private javax.swing.JLabel LexpMonth;
    private javax.swing.JLabel LexpYear;
    private javax.swing.JCheckBox PermissionChkbx;
    private javax.swing.JTextField TFAddress;
    private javax.swing.JFormattedTextField TFCCV;
    private javax.swing.JFormattedTextField TFCardnumber;
    private javax.swing.JTextField TFEmail;
    private javax.swing.JFormattedTextField TFexpMonth;
    private javax.swing.JFormattedTextField TFexpYear;
    private javax.swing.JPasswordField TFpassword;
    private javax.swing.JFormattedTextField TFphonenumber;
    private javax.swing.JTextField TFusername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onFrameClosed(String data) {
        
        
    }

    @Override
    public void onFrameClosed(String Address, double lat, double lon) {
        TFAddress.setText(Address);
        Lon = lon;
        Lat = lat;
    }
}
