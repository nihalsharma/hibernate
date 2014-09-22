package com.tm.mid.client.utils;

import com.tm.mid.client.exception.TMMIDServiceInaccessible;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;

/**
 * Created by Nihal on 9/22/14.
 */
public class WebUtil {

    public static String getResponseString(String url, ResteasyClient resteasyClient) throws TMMIDServiceInaccessible {
        try {
            ResteasyWebTarget target = resteasyClient.target(url);
            Response response = target.request().get();
            return response.readEntity(String.class);
        } catch (Exception e) {
            throw new TMMIDServiceInaccessible(e.getMessage(), e.getCause());
        }
    }
}
