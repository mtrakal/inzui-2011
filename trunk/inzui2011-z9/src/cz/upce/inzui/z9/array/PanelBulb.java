/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelBulb.java
 *
 * Created on 9.12.2011, 19:37:50
 */
package cz.upce.inzui.z9.array;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Marty
 */
public class PanelBulb extends javax.swing.JPanel {
    
    private boolean lightIsOn = false;
    private PanelArray container;
    private int row;
    private int colum;
    
    public PanelBulb(int row, int colum, PanelArray container) {
        this.setBackground(Color.gray);
        this.row = row;
        this.colum = colum;
        this.container = container;
        initComponents();
    }
    
    protected void negate() {
        lightIsOn = !lightIsOn;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (lightIsOn) {
            g.drawImage(container.getBulbOn(), 0, 0, null);
        } else {
            g.drawImage(container.getBulbOff(), 0, 0, null);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(32, 32));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    container.EvtOnBulb(row, colum);
}//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}