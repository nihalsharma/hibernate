package com.tm.midservice.utilities;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nihal on 9/17/14.
 */
public class S3Manager {


    private static final Logger LOGGER = Logger.getLogger(S3Manager.class);

    private static S3Manager instance;
    private AmazonS3 service;

    private S3Manager() throws ConfigurationException {
        service = new AmazonS3Client(new BasicAWSCredentials(ConfigReader.getInstance().getAWSAccessKey(),
                ConfigReader.getInstance().getAWSSecretKey()));
    }

    public static S3Manager getInstance() {
        if (instance == null) {
            synchronized (S3Manager.class) {
                if (instance == null) {
                    try {
                        instance = new S3Manager();
                    } catch (Exception e) {
                        LOGGER.error(e);
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instance;
    }

    private boolean doesBucketExist(String pathName){
        return service.doesBucketExist(pathName);
    }

    public int createNewBucket(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yy/MM/dd");
        String dateString = format.format(date);
        String mid = dateString.replace("/", "");
        Integer intMid = Integer.parseInt(mid);
        while(true){
            if(doesBucketExist(intMid.toString())){
                intMid ++;
            } else {
                Bucket bucket = service.createBucket(intMid.toString());
                break;
            }
        }
        return intMid;
    }
}
