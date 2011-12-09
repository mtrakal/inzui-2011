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
    private PanelArray panelArray = new PanelArray();

    public PanelCrossroads() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.gray);
        this.add(panelArray, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
        infoPanel.loggMessage("Ahoj tak uz nejak zacnem ne?");
    }
}
