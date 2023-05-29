/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.project.fooddelivery;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import waypoint.EventWaypoint;
import waypoint.MyWaypoint;
import waypoint.WaypointRender;

/**
 *
 * @author TheUltimateGamer
 */
public class MapForm extends javax.swing.JFrame {
private FrameClosedCallback callback;
    private final Set<MyWaypoint> waypoints = new HashSet<>();
    private double Lattitude,Longitude;
    

    
  
    public MapForm(FrameClosedCallback callback) {
        this.callback = callback;
        initComponents();
        initComponents2();
    }

    private void initComponents2(){
        setIconImage(new ImageIcon("icons\\icon.png").getImage());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
        
        GeoPosition geo = new GeoPosition(24.04613816134453, 32.88001743244494);
        jXMapViewer.setAddressLocation(geo);
        jXMapViewer.setZoom(12);

        //  Create event mouse move
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                           java.awt.Point p = e.getPoint();
                           GeoPosition geo = jXMapViewer.convertPointToGeoPosition(p);
                           Lattitude = geo.getLatitude();
                           Longitude = geo.getLongitude();
                           System.out.println("X:"+Lattitude+",Y:"+Longitude);
                           addWaypoint(new MyWaypoint(new GeoPosition(geo.getLatitude(), geo.getLongitude())));

                       
                }
           });
        jXMapViewer.addMouseMotionListener(mm);

        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
    
    
    }
    
    private void addWaypoint(MyWaypoint waypoint) {
        clearWaypoint();
        waypoints.add(waypoint);
        initWaypoint();
    }

    private void initWaypoint() {
        WaypointPainter<MyWaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer.setOverlayPainter(wp);
        for (MyWaypoint d : waypoints) {
            jXMapViewer.add(d.getButton());
        }
    }

    private void clearWaypoint() {
        for (MyWaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.clear();
        initWaypoint();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapViewer = new org.jxmapviewer.JXMapViewer();
        ConfirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewerLayout = new javax.swing.GroupLayout(jXMapViewer);
        jXMapViewer.setLayout(jXMapViewerLayout);
        jXMapViewerLayout.setHorizontalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewerLayout.createSequentialGroup()
                .addContainerGap(883, Short.MAX_VALUE)
                .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXMapViewerLayout.setVerticalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewerLayout.createSequentialGroup()
                .addContainerGap(614, Short.MAX_VALUE)
                .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXMapViewer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXMapViewer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        Maps maps = new Maps();
        if(waypoints.isEmpty()){
            callback.onFrameClosed("");
            this.setVisible(false);
            return;
        }
        
        String info = maps.getGeoLocationInfo(Lattitude, Longitude);
        if(info!=null){
            callback.onFrameClosed(info);
        }else{
            callback.onFrameClosed("");

        }
        
        this.setVisible(false);
        
    }//GEN-LAST:event_ConfirmButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private org.jxmapviewer.JXMapViewer jXMapViewer;
    // End of variables declaration//GEN-END:variables
}
