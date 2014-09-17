package com.tm.midservice.utilities;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.InputStream;

/**
 * Created by Nihal on 9/14/14.
 */
public class ConfigReader {


    public static final java.lang.String DBSERVER = "DB_SERVER";
    public static final java.lang.String DBNAME = "DB_NAME";
    public static final java.lang.String USERNAME = "DB_USERID";
    public static final java.lang.String PASSWORD = "DB_PASSWD";
    public static final java.lang.String DBPORT = "DB_PORT";

    private static final String AWS_ACCESS_KEY = "aws.accessKey";
    private static final String AWS_SECRET_KEY = "aws.secretKey";
    private static final java.lang.String AUTH_TOKEN = "AUTH_TOKEN";

    private static ConfigReader instance;
    private final Configuration config;

    private ConfigReader() throws ConfigurationException {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        PropertiesConfiguration propsConfig = new PropertiesConfiguration();
        propsConfig.load(stream);
        config = propsConfig;
    }

    public static ConfigReader getInstance() throws ConfigurationException {
        if (instance == null) {
            synchronized (ConfigReader.class) {
                if (instance == null) {
                    instance = new ConfigReader();
                }
            }
        }
        return instance;
    }

    public String getAuthToken() {
        return config.getString(AUTH_TOKEN);
    }

    public String getAWSAccessKey() {
        return config.getString(AWS_ACCESS_KEY);
    }

    public String getAWSSecretKey() {
        return config.getString(AWS_SECRET_KEY);
    }

    public String getDbserver() {return config.getString(DBSERVER);}

    public String getDbname() {return config.getString(DBNAME);}

    public String getUsername() {
        return config.getString(USERNAME);
    }

    public String getPassword() {
        return config.getString(PASSWORD);
    }

    public String getDbport() {
        return config.getString(DBPORT);
    }
}
