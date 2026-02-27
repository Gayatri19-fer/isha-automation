package org.isha.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties = new Properties();

	
    static {
        try {
            String env = System.getProperty("env", "uat");
            System.out.println(
            	    ConfigReader.class.getClassLoader().getResource("config/uat.properties")
            	);

            InputStream input = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("config/" + env + ".properties");

            if (input == null) {
                throw new RuntimeException("Config file not found for env: " + env);
                
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}


