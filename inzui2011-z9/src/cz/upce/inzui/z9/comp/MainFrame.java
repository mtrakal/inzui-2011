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
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author martin.kaplan
 */
public final class MainFrame extends JFrame {

    public static String configFile = "config.properties";
    public static final String LOG4J_CONSOLE_LOGGER = "console";
    public static final String LOG4J_AWTCONSOLE_APPENDER = "AWTCONSOLE";
    public static final String LOG4J_APP_LOGGER = "app";
    public static int P_WIDTH = 410;
    public static int P_HEIGHT = 410;
    private PanelCrossroads crossroads;
    //
    private JButton exitButton = new JButton();
    private JButton initButton = new JButton();
    private JButton stopButton = new JButton();
    private JButton startButton = new JButton();
    private JRadioButton buttonOne = new JRadioButton("One");
    private JRadioButton buttonCross = new JRadioButton("Cross");
    private ButtonGroup buttonGroup = new ButtonGroup();

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("INZUI 2011");
        this.setSize(new Dimension(P_WIDTH, P_HEIGHT));
        setLocationOnMiddle();
        buttonGroup.add(buttonOne);
        buttonGroup.add(buttonCross);
        crossroads = new PanelCrossroads(this);
        this.setLayout(new BorderLayout());
        this.add(crossroads, BorderLayout.CENTER);
        this.add(initEastPanel(), BorderLayout.EAST);
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

    private JPanel initEastPanel() {
        JPanel eastPanel = new JPanel(new GridLayout(6, 0, 4, 4));
        eastPanel.setBackground(Color.gray);
        eastPanel.setBorder(new BevelBorder(0));
        eastPanel.add(buttonOne);
        eastPanel.add(buttonCross);
        buttonCross.setSelected(true);
        buttonOne.setBackground(Color.gray);
        buttonCross.setBackground(Color.gray);
        ////
        eastPanel.add(initButton);
        initButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initArray();
            }
        });
        initButton.setText("Inicializuj");
        ////
        eastPanel.add(startButton);
        startButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // TO DO spust algoritmus
            }
        });
        startButton.setText("Start");
////

        eastPanel.add(stopButton);
        stopButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // TO DO STOP algoritmus
            }
        });
        stopButton.setText("Stop");
        ////
        eastPanel.add(exitButton);
        exitButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        exitButton.setText("Exit");


        return eastPanel;
    }

    private void initArray() {
        crossroads.initArray();
    }

    public boolean corss() {
        return buttonCross.isSelected();
    }
}
