package com.tm.midservice.db.core;

import com.ibatis.common.jdbc.ScriptRunner;
import com.mysql.jdbc.Connection;
import com.tm.midservice.exception.TMMIDException;
import com.tm.midservice.utilities.ConfigReader;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nihal on 9/10/14.
 */
public class DataBaseManager {

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String MYSQL_JDBC = "jdbc:mysql://";
    private static Connection CONNECTION = null;
    private static DataBaseManager dbManager;
    private StringBuilder stringBuilder;


    private static Logger LOGGER = Logger.getLogger(DataBaseManager.class);

    private DataBaseManager() {

        LOGGER.debug("***************************Loading properties*********************");
        //LoadProperties loadProps = new LoadProperties();
        //Properties properties = loadProps.getLoadedProperties();
        stringBuilder = new StringBuilder(MYSQL_JDBC);

        //String databaseName = stringBuilder.append(properties.getProperty(Constants.DBSERVER)).append(":").append(properties.getProperty(Constants.DBPORT)).append("/").append(properties.getProperty(Constants.DBNAME)).toString();
        this.CONNECTION = getDBConnection();
        if (this.CONNECTION == null) {
            throw new TMMIDException();
        }
    }

    private Connection getDBConnection() {
        try {
            stringBuilder = new StringBuilder(MYSQL_JDBC);
            ConfigReader config = ConfigReader.getInstance();
            String databaseName = stringBuilder.append(config.getDbserver()).append(":").append(config.getDbport()).append("/").append(config.getDbname()).toString();
            Class.forName(DRIVER_NAME);
            CONNECTION = (Connection) DriverManager.getConnection(databaseName, config.getUsername(), config.getPassword());
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class Not Found Exception in DataBaseManager");
        } catch (SQLException e) {
            LOGGER.error("SQLException Occurred in DataBaseManager");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        return CONNECTION;
    }

    public static Connection getConnection() {
        if (null == dbManager) {
            dbManager = new DataBaseManager();
            return CONNECTION;
        }
        return CONNECTION;
    }

    public static boolean executeBulkQuery(Connection conn) {
        boolean retBool = false;
        // Give the input file to Reader
        ScriptRunner sr = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            sr = new ScriptRunner(conn, false, false);
            inputStream = DataBaseManager.class.getClassLoader().getResourceAsStream("sqlDump.sql");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            sr.runScript(reader);
            retBool = true;
        } catch (FileNotFoundException e) {
            throw new TMMIDException("FileNotFoundException occurred while running sql dump", e);
        } catch (SQLException e) {
            throw new TMMIDException("SQLEXCEPTION occurred while running sql dump", e);
        } catch (IOException e) {
            throw new TMMIDException(" IOException occurred while running sql dump", e);
        }
        return retBool;
    }

}

