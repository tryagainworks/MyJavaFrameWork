/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframework.pkgGUIContainers;

import myframework.pkgDataBase.ClsHSQLDBDataBase;

/**
 *
 * @author Win97User
 */
public class MyGlbJInternalFrame extends javax.swing.JInternalFrame {

    public ClsHSQLDBDataBase objDBHSQ;
    public ClsGUIContainers objGUIContainer;
    public PnlDataManupulation pnl;
    /**
     * Creates new form myJInternalFrame
     */
    public MyGlbJInternalFrame() {
        initComponents();
        pnl = new PnlDataManupulation(tblBar, this);
        tblBar.setLocation(0,0);
        tblBar.setSize(600,50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblBar = new javax.swing.JToolBar();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tblBar.setBackground(new java.awt.Color(102, 204, 255));
        tblBar.setFloatable(false);
        tblBar.setRollover(true);
        tblBar.setMaximumSize(new java.awt.Dimension(13, 50));
        tblBar.setMinimumSize(new java.awt.Dimension(13, 50));
        tblBar.setPreferredSize(new java.awt.Dimension(13, 50));
        getContentPane().add(tblBar, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        pnl.fnRefresh(null);
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToolBar tblBar;
    // End of variables declaration//GEN-END:variables
}
