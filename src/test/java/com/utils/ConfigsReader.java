package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


    /**
     * Reads a properties file from the given path
     */
    
    public class ConfigsReader {

        static Properties prop;

        public static void readProperties(String filePath) {
            try (FileInputStream fis = new FileInputStream(filePath)) {
                prop = new Properties();
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("❌ Could not load config file: " + filePath);
            }
        }

        public static String getProperty(String key) {
            return prop.getProperty(key);
        }
    }

//    public static void readProperties(String filePath) {
//        try (FileInputStream fis = new FileInputStream(filePath)) {
//            prop = new Properties();
//            prop.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Gets the property value for the given key
//     */
//    public static String getProperty(String key) {
//        if (prop == null) {
//            throw new IllegalStateException("Properties file not loaded. Call readProperties() first.");
//        }
//        return prop.getProperty(key);
//    }
//}
