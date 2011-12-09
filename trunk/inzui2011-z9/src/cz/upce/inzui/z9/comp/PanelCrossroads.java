/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.inzui.z9.comp;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author martin.kaplan
 */
public class PanelCrossroads extends JPanel {

    InfoPanel infoPanel = new InfoPanel();

    public PanelCrossroads() {
        this.setLayout(new MigLayout());
        this.add(infoPanel);
        infoPanel.loggMessage("Ahoj tak uz nejak zacnem ne?");
    }
}
