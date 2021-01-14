package com.securepay.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyFileManager {

    Logger logger = Logger.getLogger(PropertyFileManager.class.getName());

    public Properties getProps() throws IOException {
        String propertyFileName = "application-e2e.properties";
        Properties props = new Properties();


        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName)) {
            props.load(inputStream);
            logger.log(Level.INFO, "Config Property Loaded");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Faled to load config properties. Abort!!!" + e.toString());
            e.printStackTrace();
            throw e;
        }
        return props;
    }
}
