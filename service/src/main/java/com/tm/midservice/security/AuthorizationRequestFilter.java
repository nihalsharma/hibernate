package com.tm.midservice.security;

import com.tm.midservice.utilities.ConfigReader;
import org.apache.commons.configuration.ConfigurationException;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

@Provider
@ServerInterceptor
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext)
            throws IOException {

        final SecurityContext securityContext =requestContext.getSecurityContext();
        String header = requestContext.getHeaderString("tmauthorize");
        try {
            if (securityContext == null || header == null || header == "" || (header != null && !header.equals(ConfigReader.getInstance().getAuthToken()))) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                        .entity("User cannot access the resource.")
                        .build());
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}