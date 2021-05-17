package com.test.lakshmi.selenium.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static Properties prop = readFromPropertyFile();
    
    /**
     * Singleton Pattern to get only one instance of property file
     */
    private Settings(){ }
    private static Settings settings = new Settings();
    public static Properties getInstance(){
        return prop;
    }

    
    /**
     * 
     * Function to read value from global property file
     */
    private static Properties readFromPropertyFile(){
        Properties properties = new Properties();
        String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath()+
                System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "test"
                + System.getProperty("file.separator")+ "resources";
        try {
            properties.load(new FileInputStream(relativePath + System.getProperty("file.separator") +
                    "GlobalSettings.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
