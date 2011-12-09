/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.inzui.z9.comp;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 *
 * @author marty
 */
public class JTextAreaAppender extends AppenderSkeleton {

    JTextArea jTextArea;

    @Override
    protected void append(final LoggingEvent arg0) {
        if (jTextArea != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    while (jTextArea.getLineCount() > 1000) {
                        try {
                            jTextArea.replaceRange(null, 0, jTextArea.getLineEndOffset(0));
                        } catch (BadLocationException ex) {
                            ex.printStackTrace();
                        }
                    }
                    jTextArea.append(" " + arg0.getRenderedMessage() + "\r\n");
                    jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
                }
            });
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }

    @Override
    public void close() {
    }

    public void setJTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }
}
