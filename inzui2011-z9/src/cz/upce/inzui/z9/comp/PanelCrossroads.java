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
        this.mf=mf;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.gray);
        panelArray = new PanelArray(this);
        this.add(panelArray, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
        infoPanel.loggMessage("Ahoj tak uz nejak zacnem ne?");
    }

    public void initArray() {
        panelArray.init();
    }

    public boolean cross() {
        return mf.corss();
    }
}
