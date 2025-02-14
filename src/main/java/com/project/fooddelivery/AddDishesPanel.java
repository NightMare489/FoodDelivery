/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.project.fooddelivery;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author TheUltimateGamer
 */
public class AddDishesPanel extends javax.swing.JPanel {

        String IconFilePath ="";
    
    /**
     * Creates new form AddPanel
     */
    public AddDishesPanel() {
        initComponents();
        initComponents2();
    }
    
   void initComponents2(){
        jPanel1.hide();
        setPreferredSize(new Dimension(0, 105));
        this.setBorder(new LineBorder(Color.black));
        Icon.setIcon(new javax.swing.ImageIcon("icons\\plus.png")); 
        DishIcon.setIcon(new javax.swing.ImageIcon("icons\\plus.png"));
        Check.setIcon(new javax.swing.ImageIcon("icons\\Check.png"));
        Cancel.setIcon(new javax.swing.ImageIcon("icons\\delete.png"));

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DishIcon = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Desc = new javax.swing.JTextField();
        EGPLabel = new javax.swing.JLabel();
        Check = new javax.swing.JLabel();
        Cancel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Icon = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(510, 105));
        setMinimumSize(new java.awt.Dimension(510, 105));
        setLayout(null);

        jPanel1.setLayout(null);

        DishIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DishIconMouseClicked(evt);
            }
        });
        jPanel1.add(DishIcon);
        DishIcon.setBounds(5, 5, 90, 90);

        Price.setToolTipText("Dish Price");
        jPanel1.add(Price);
        Price.setBounds(320, 60, 90, 22);

        Name.setToolTipText("Dish Name");
        jPanel1.add(Name);
        Name.setBounds(110, 10, 240, 22);

        Desc.setToolTipText("Dish Description");
        jPanel1.add(Desc);
        Desc.setBounds(110, 40, 190, 50);

        EGPLabel.setText("EGP");
        jPanel1.add(EGPLabel);
        EGPLabel.setBounds(420, 60, 30, 16);

        Check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckMouseClicked(evt);
            }
        });
        jPanel1.add(Check);
        Check.setBounds(450, 60, 30, 30);

        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });
        jPanel1.add(Cancel);
        Cancel.setBounds(450, 10, 30, 30);

        add(jPanel1);
        jPanel1.setBounds(5, 2, 500, 100);

        jPanel2.setLayout(null);

        Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconMouseClicked(evt);
            }
        });
        jPanel2.add(Icon);
        Icon.setBounds(200, 10, 90, 90);

        add(jPanel2);
        jPanel2.setBounds(5, 2, 500, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconMouseClicked
        jPanel2.hide();
        jPanel1.show();

        
        
    }//GEN-LAST:event_IconMouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        jPanel1.hide();
        jPanel2.show();
        Desc.setText("");
        Name.setText("");
        Price.setText("");
        IconFilePath = "";
        DishIcon.setIcon(new javax.swing.ImageIcon("icons\\plus.png"));

        
        
// TODO add your handling code here:
    }//GEN-LAST:event_CancelMouseClicked

    private void DishIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DishIconMouseClicked
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an image");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "png");

        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        
        // Check if a file was selected
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            IconFilePath = filePath;
            DishIcon.setIcon(new javax.swing.ImageIcon(filePath));
            

        }
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                }catch(Exception e){
            System.out.println(e);
        }
        
    }//GEN-LAST:event_DishIconMouseClicked

    private void CheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckMouseClicked
        try{
        if(IconFilePath.equals("") || Name.getText().equals("") || Desc.getText().equals("") || Price.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter All data including image",
            "Invalid Data", JOptionPane.ERROR_MESSAGE);
         return;
        }
        Path sourcePath = Path.of(IconFilePath);
        Path destinationDir = Path.of("icons\\");
        Path destinationPath = destinationDir.resolve(Name.getText() + ".png");
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING); 
        Dish dish = new Dish( Name.getText(),Desc.getText(),Price.getText());
        DishesForm frame = (DishesForm) SwingUtilities.getWindowAncestor(this);
        dish.AddDishToRestaurant(frame.ResName);
        JOptionPane.showMessageDialog(this, "Dish added successfully",
            "Success", JOptionPane.INFORMATION_MESSAGE);
        
            DishesForm jframeDishesForm = new DishesForm(frame.ResName,frame.state);
            jframeDishesForm.setVisible(true);
            jframeDishesForm.setLocation(frame.getLocationOnScreen());
            frame.setVisible(false);
        
        
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_CheckMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel Check;
    private javax.swing.JTextField Desc;
    private javax.swing.JLabel DishIcon;
    private javax.swing.JLabel EGPLabel;
    private javax.swing.JLabel Icon;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Price;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
