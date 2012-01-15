/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.inzui.z9.comp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author martin
 */
public class Config {

    private static Logger logger = Logger.getLogger(Config.class);
    public static String C_ROW = "ROW";
    public static String C_COL = "COL";
    public static String CONFIG_FILE_NAME =  "config.properties";

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (FileNotFoundException ex) {
            logger.error("FileNotFound", ex);
        } catch (IOException ex) {
            logger.error("IO ex" + ex);
        }
        return properties;
    }
}
