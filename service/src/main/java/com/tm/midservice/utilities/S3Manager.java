package com.tm.midservice.utilities;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectListing;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;

/**
 * Created by BigP on 9/14/14.
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

    public ObjectListing getListObjects(String path) {
        /*String bucket = S3Util.getBucket(path);
        String bucketPath = S3Util.getPath(path);
        try {
            return service.listObjects(new ListObjectsRequest().withBucketName(bucket).withPrefix(bucketPath));
        } catch (Exception e) {
            LOGGER.error("Error finding path: " + path + " in bucket: " + bucket);
        }*/
        return null;
    }

    public void deletePathIfExists(String path) {
        /*ObjectListing summaries = getListObjects(path);
        if (summaries != null) {
            for (S3ObjectSummary summary : summaries.getObjectSummaries()) {
                try {
                    service.deleteObject(summary.getBucketName(), summary.getKey());
                } catch (Exception e) {
                    LOGGER.error("Error deleting path: " + summary.getKey() + " in bucket: " + summary.getBucketName());
                }
            }
        }*/
    }
}
