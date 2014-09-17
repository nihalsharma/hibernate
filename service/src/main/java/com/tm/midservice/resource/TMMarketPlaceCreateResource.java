package com.tm.midservice.resource;

import com.google.gson.Gson;
import com.tm.midservice.S3.S3Manager;
import com.tm.midservice.db.dto.Company;
import com.tm.midservice.db.dto.CompanyCategoryMap;
import com.tm.midservice.db.dto.User;
import com.tm.midservice.db.impl.BaseDaoImpl;
import com.tm.midservice.db.service.BaseDao;
import com.tm.midservice.exception.TMMIDException;
import org.apache.log4j.Logger;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Nihal on 9/14/14.
 */
@Path("/create")
public class TMMarketPlaceCreateResource {

    private static final Logger LOGGER = Logger.getLogger(TMMarketPlaceCreateResource.class);
    private static BaseDao baseDao;

    public TMMarketPlaceCreateResource() {
        baseDao = new BaseDaoImpl();
    }

    @POST
    @Path("/company")
    @Produces("application/json")
    public String createCompany(String companyJson){
        boolean created = Boolean.FALSE;
        Gson gson = new Gson();
        try{
            Company company = new Gson().fromJson(companyJson, Company.class);
            //create S3 Bucket
            int mid = S3Manager.getInstance().createNewBucket();
            company.setMid(mid);
            if(company != null){
                baseDao.save(company);
            }
            created = Boolean.TRUE;
        } catch (Exception e){
            throw new TMMIDException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }

    @POST
    @Path("/user")
    @Produces("application/json")
    public String createUser(String userJson){
        boolean created = Boolean.FALSE;
        User user = new Gson().fromJson(userJson, User.class);
        Gson gson = new Gson();
        try{
            if(user != null){
                baseDao.save(user);
            }
            created = Boolean.TRUE;
        } catch (Exception e){
            throw new TMMIDException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }

    @POST
    @Path("/companyCategoryMap")
    @Produces("application/json")
    public String createCompanyCategoryMap(String companyCatJson){
        boolean created = Boolean.FALSE;
        Gson gson = new Gson();
        CompanyCategoryMap companyCatMap = new Gson().fromJson(companyCatJson, CompanyCategoryMap.class);
        try{
            if(companyCatMap != null){
                baseDao.save(companyCatMap);
            }
            created = Boolean.TRUE;
        } catch (Exception e){
            throw new TMMIDException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }

}
