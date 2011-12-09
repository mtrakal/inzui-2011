/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.inzui.z9.comp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author martin.kaplan
 */
public class InfoPanel extends JPanel {

    private JTextArea jTextAreaConsole = new JTextArea();
    private JTextAreaAppender jTextAreaAppender;
    private static Logger connLogger = Logger.getLogger(MainFrame.LOG4J_CONSOLE_LOGGER);
    private static Logger logger = Logger.getLogger(MainFrame.LOG4J_APP_LOGGER);
    private JScrollPane jScrollPanel = new JScrollPane();
    private Object lock = new Object();

    public InfoPanel() {
        this.setBackground(Color.gray);
        this.setLayout(new BorderLayout());
        PropertyConfigurator.configure("log4j.properties.txt");
        this.setPreferredSize(new Dimension(168, 80));
        jScrollPanel.setViewportView(jTextAreaConsole);
        this.add(jScrollPanel, BorderLayout.CENTER);
        jTextAreaAppender = (JTextAreaAppender) Logger.getLogger(MainFrame.LOG4J_CONSOLE_LOGGER).getAppender(MainFrame.LOG4J_AWTCONSOLE_APPENDER);
        if (jTextAreaAppender != null) {
            jTextAreaAppender.setJTextArea(jTextAreaConsole);
        } else {
            logger.info("No appender for JTextArea");
        }
        jTextAreaConsole.setBackground(Color.black);
    }

    public void loggMessage(String message) {
        synchronized (lock) {
            jTextAreaConsole.setForeground(Color.white);
            connLogger.info(message);
        }
    }

    public void loggError(String message) {
        synchronized (lock) {
            jTextAreaConsole.setForeground(Color.red);
            connLogger.info(message);
        }
    }
}
