/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.inzui.z9.comp;

import cz.upce.inzui.z9.array.PanelArray;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author martin.kaplan
 */
public class PanelCrossroads extends JPanel {
    
    private InfoPanel infoPanel = new InfoPanel();
    private PanelArray panelArray;
    private MainFrame mf;
    
    public PanelCrossroads(MainFrame mf, int rows, int colums) {
        this.mf = mf;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.gray);
        panelArray = new PanelArray(this, rows, colums);
        this.add(panelArray, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
    }
    
    public void addLoggMessage(String message) {
        this.infoPanel.loggMessage(message);
    }
    
    public void addErrorMessage(String message) {
        this.infoPanel.loggError(message);
    }
    
    public void initArray() {
        panelArray.init();
    }
    
    public boolean cross() {
        return mf.corss();
    }
    
    public boolean[][] toArray() {
        boolean[][] array = new boolean[this.panelArray.getRows()][this.panelArray.getColums()];
        for (int x = 0; x < this.panelArray.getRows(); x++) {
            for (int y = 0; y < this.panelArray.getColums(); y++) {
                array[x][y] = this.panelArray.isLightIsOn(x, y);
            }
        }
        return array;
    }
    
    public boolean isLookingForSolution() {
        return mf.isLookingForSolution();
    }
}
