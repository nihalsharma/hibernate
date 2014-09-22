package com.tm.midservice.resource;

import com.google.gson.Gson;
import com.tm.midservice.exception.TMMarketPlaceDatabaseException;
import com.tm.midservice.utilities.S3Manager;
import com.tm.midservice.db.dto.Company;
import com.tm.midservice.db.dto.CompanyCategoryMap;
import com.tm.midservice.db.dto.CompanyAttributes;
import com.tm.midservice.db.dto.User;
import com.tm.midservice.db.impl.BaseDaoImpl;
import com.tm.midservice.db.impl.CompanyDaoImpl;
import com.tm.midservice.db.service.BaseDao;
import com.tm.midservice.db.service.CompanyDao;
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
    private static CompanyDao companyDao;

    public TMMarketPlaceCreateResource() {
        baseDao = new BaseDaoImpl();
        companyDao = new CompanyDaoImpl();
    }

    @POST
    @Path("/company")
    @Produces("application/json")
    public String createCompany(String companyJson) {
        boolean created = Boolean.FALSE;
        Gson gson = new Gson();
        try {
            Company company = new Gson().fromJson(companyJson, Company.class);
            //create S3 Bucket
            int mid = S3Manager.getInstance().createNewBucket();
            company.setMid(mid);
            if (company != null) {
                baseDao.save(company);
            }
            created = Boolean.TRUE;
        } catch (Exception e) {
            throw new TMMarketPlaceDatabaseException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }


    @POST
    @Path("/user")
    @Produces("application/json")
    public String createTMWRSClient(String tmwrsClientJson) {
        boolean created = Boolean.FALSE;
        Gson gson = new Gson();
        try {
            CompanyAttributes client = new Gson().fromJson(tmwrsClientJson, CompanyAttributes.class);
            if (client != null) {
                Company company = companyDao.getCompanyByMID(client.getMid());
                if (company != null) {
                    return gson.toJson(created);
                }
                baseDao.save(client);
            }
            created = Boolean.TRUE;
        } catch (Exception e) {
            throw new TMMarketPlaceDatabaseException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }

    @POST
    @Path("/user")
    @Produces("application/json")
    public String createUser(String userJson) {
        boolean created = Boolean.FALSE;
        User user = new Gson().fromJson(userJson, User.class);
        Gson gson = new Gson();
        try {
            if (user != null) {
                baseDao.save(user);
            }
            created = Boolean.TRUE;
        } catch (Exception e) {
            throw new TMMarketPlaceDatabaseException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }

    @POST
    @Path("/company-category-map")
    @Produces("application/json")
    public String createCompanyCategoryMap(String companyCatJson) {
        boolean created = Boolean.FALSE;
        Gson gson = new Gson();
        CompanyCategoryMap companyCatMap = new Gson().fromJson(companyCatJson, CompanyCategoryMap.class);
        try {
            if (companyCatMap != null) {
                baseDao.save(companyCatMap);
            }
            created = Boolean.TRUE;
        } catch (Exception e) {
            throw new TMMarketPlaceDatabaseException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }


    /*@GET
    @Path("/all-company-category-map")
    @Produces("application/json")
    public String createAllCompanyCategoryMap() {
        boolean created = Boolean.FALSE;
        Gson gson = new Gson();
        List<CompanyCategoryMap> companyCatMap = Constants.createcategoryMap();
        try {
            if (companyCatMap != null) {
                baseDao.saveAll(companyCatMap);
            }
            created = Boolean.TRUE;
        } catch (Exception e) {
            throw new TMMarketPlaceDatabaseException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }*/

    /*@GET
    @Path("/allTMWRSClient")
    @Produces("application/json")
    public String createAllTMWRSClient() {
        boolean created = Boolean.FALSE;
        Gson gson = new Gson();
        List<CompanyAttributes> companyCatMap = Constants.tmwrsClients();
        try {
            if (companyCatMap != null) {
                baseDao.saveAll(companyCatMap);
            }
            created = Boolean.TRUE;
        } catch (Exception e) {
            throw new TMMarketPlaceDatabaseException(e.getMessage());
        }
        String json = gson.toJson(created);
        return json;
    }*/




}
