/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.project.fooddelivery;

import data.RoutingData;
import data.RoutingService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<RoutingData> routingData = new ArrayList<>();
    private double Lattitude,Longitude;
    private int state;

    
  
    public MapForm(FrameClosedCallback callback,int state) {
        this.callback = callback;
        this.state = state;
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

        if(state==2){
            Confirm.hide();
        }
        
        //  Create event mouse move
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(state == 0 || state == 1){
                           java.awt.Point p = e.getPoint();
                           GeoPosition geo = jXMapViewer.convertPointToGeoPosition(p);
                           Lattitude = geo.getLatitude();
                           Longitude = geo.getLongitude();
                           System.out.println("X:"+Lattitude+",Y:"+Longitude);
                           addWaypoint(new MyWaypoint(new GeoPosition(geo.getLatitude(), geo.getLongitude())));
                           
                           if(state == 1){
                           addroute(24.089015072633437, 32.89867204002298,geo.getLatitude(), geo.getLongitude());
                           }

                    }
                }
           });
        jXMapViewer.addMouseMotionListener(mm);

        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
    

    
    }
    
    public void addroute(double fromlat,double fromlon,double toLat,double toLon){
        routingData.clear();
        routingData = RoutingService.getInstance().routing(fromlat, fromlon, toLat, toLon);
        jXMapViewer.setRoutingData(routingData);
    }
    
    public void addWaypoint(MyWaypoint waypoint) {
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

        jXMapViewer = new data.JXMapViewerCustom();
        Confirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewerLayout = new javax.swing.GroupLayout(jXMapViewer);
        jXMapViewer.setLayout(jXMapViewerLayout);
        jXMapViewerLayout.setHorizontalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewerLayout.createSequentialGroup()
                .addContainerGap(882, Short.MAX_VALUE)
                .addComponent(Confirm)
                .addContainerGap())
        );
        jXMapViewerLayout.setVerticalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewerLayout.createSequentialGroup()
                .addContainerGap(619, Short.MAX_VALUE)
                .addComponent(Confirm)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        Maps maps = new Maps();
        if(waypoints.isEmpty()){
            callback.onFrameClosed("",0.0,0.0);
            this.setVisible(false);
            return;
        }
        
        String info = maps.getGeoLocationInfo(Lattitude, Longitude);
        if(info!=null){
            callback.onFrameClosed(info,Lattitude,Longitude);
        }
        
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirm;
    private data.JXMapViewerCustom jXMapViewer;
    // End of variables declaration//GEN-END:variables
}
