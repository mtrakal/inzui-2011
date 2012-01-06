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

    public PanelCrossroads(MainFrame mf) {
        this.mf = mf;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.gray);
        panelArray = new PanelArray(this);
        this.add(panelArray, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
        infoPanel.loggMessage("Ahoj tak uz nejak zacnem ne?");
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
        boolean[][] array = new boolean[this.panelArray.getROWS()][this.panelArray.getCOLUMS()];
        for (int x = 0; x < this.panelArray.getROWS(); x++) {
            for (int y = 0; y < this.panelArray.getCOLUMS(); y++) {
                array[x][y] = this.panelArray.isLightIsOn(x, y);
            }
        }
        return array;
    }
}
