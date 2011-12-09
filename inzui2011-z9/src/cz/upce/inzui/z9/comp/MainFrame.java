/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.inzui.z9.comp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author martin.kaplan
 */
public final class MainFrame extends JFrame {

    public static String configFile = "config.properties";
    public static final String LOG4J_CONSOLE_LOGGER = "console";
    public static final String LOG4J_AWTCONSOLE_APPENDER = "AWTCONSOLE";
    public static final String LOG4J_APP_LOGGER = "app";
    public static int P_WIDTH = 200;
    public static int P_HEIGHT = 300;
    private PanelCrossroads crossroads;
    //
    private JButton exitButton = new JButton();
    private JButton startButton = new JButton();

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("INZUI 2011");
        this.setSize(new Dimension(P_WIDTH, P_HEIGHT));
        setLocationOnMiddle();
        crossroads = new PanelCrossroads();
        this.setLayout(new BorderLayout());
        this.add(crossroads, BorderLayout.CENTER);
        this.add(initBottomPanel(), BorderLayout.SOUTH);
    }

    public void setLocationOnMiddle() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Point location = new Point();
        location.x = (int) (dim.getWidth() - P_WIDTH) / 2;
        location.y = (int) (dim.getHeight() - P_HEIGHT) / 2;
        this.setLocation(location);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                UIManager.put("TabbedPane.borderHightlightColor", UIManager.getColor("TabbedPane.unselectedBackground"));
                UIManager.put("TabbedPane.contentAreaColor", Color.gray);
                UIManager.put("TabbedPane.darkShadow", Color.DARK_GRAY);
                UIManager.put("TabbedPane.focus", Color.gray);
                UIManager.put("TabbedPane.light", Color.gray);
                UIManager.put("TabbedPane.selectHighlight", Color.lightGray);
                UIManager.put("TabbedPane.selected", Color.gray);
                UIManager.put("TabbedPane.unselectedBackground", Color.white);
                new MainFrame().setVisible(true);
            }
        });
    }

    private JPanel initBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridLayout(0, 2, 4, 4));
        bottomPanel.setBackground(Color.gray);
        this.add(bottomPanel, BorderLayout.SOUTH);
        ////
        bottomPanel.add(exitButton);
        exitButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        exitButton.setText("Exit");
        ////
        bottomPanel.add(startButton);
        startButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // TO DO spust algoritmus
            }
        });
        startButton.setText("Start");

        return bottomPanel;
    }
}
