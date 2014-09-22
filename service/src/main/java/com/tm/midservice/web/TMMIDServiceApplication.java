package com.tm.midservice.web;

import com.tm.midservice.resource.TMMarketPlaceCreateResource;
import com.tm.midservice.resource.TMMarketPlaceGetResource;
import com.tm.midservice.resource.TMMarketPlaceUpdateResource;
import com.tm.midservice.security.AuthorizationRequestFilter;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nihal on 9/10/14.
 */
public class TMMIDServiceApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public TMMIDServiceApplication() {
        System.out.println("****************Loading of all services begins here***********");
        singletons.add(new TMMarketPlaceGetResource());
        singletons.add(new TMMarketPlaceUpdateResource());
        singletons.add(new TMMarketPlaceCreateResource());
        singletons.add(new AuthorizationRequestFilter());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
