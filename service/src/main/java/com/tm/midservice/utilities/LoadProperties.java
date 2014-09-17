package com.tm.midservice.utilities;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Nihal on 9/10/14.
 */
public class LoadProperties {

    private static Logger LOGGER = Logger.getLogger(LoadProperties.class);
    private String propertiesFilePath = "config.properties";
    private Properties loadedProperties;

    public LoadProperties() {
        load(propertiesFilePath);
    }

    public void load(String filePath) {

        if (loadedProperties != null) {
            Iterator<?> names = loadedProperties.keySet().iterator();
            while (names.hasNext()) {
                String name = (String) names.next();
                System.clearProperty(name);
            }
        }
        LOGGER.debug("***************************Loading properties*********************");

        loadedProperties = new java.util.Properties();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
            loadedProperties.load(inputStream);

            Enumeration<?> names = loadedProperties.propertyNames();
            while (names.hasMoreElements()) {
                String key = (String) names.nextElement();
                System.setProperty(key, loadedProperties.getProperty(key));
                //logger.debug("Loading key " + key + ", value:" + loadProps.getProperty(key));
            }
        } catch (IOException ioe) {
            LOGGER.error("IO Error while loading properties", ioe);
        }
    }

    public Properties getLoadedProperties() {
        return loadedProperties;
    }
}
