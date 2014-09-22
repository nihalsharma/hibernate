package com.tm.midservice.resource;

import com.google.gson.Gson;
import com.tm.midservice.db.dto.Company;
import com.tm.midservice.db.impl.BaseDaoImpl;
import com.tm.midservice.db.impl.CompanyDaoImpl;
import com.tm.midservice.db.service.BaseDao;
import com.tm.midservice.db.service.CompanyDao;
import com.tm.midservice.exception.TMMarketPlaceDatabaseException;
import org.apache.log4j.Logger;

import javax.ws.rs.*;

/**
 * Created by Nihal on 9/11/14.
 */
@Path("/update")
public class TMMarketPlaceUpdateResource {

    private static final Logger LOGGER = Logger.getLogger(TMMarketPlaceGetResource.class);
    private BaseDao baseDao;
    private CompanyDao companyDao;

    public TMMarketPlaceUpdateResource() {
        baseDao = new BaseDaoImpl();
        companyDao = new CompanyDaoImpl();
    }

    @POST
    @Path("/company/")
    @Produces("application/json")
    public String updateCompany(String companyJson){
        Gson gson = new Gson();
        Boolean saveCompany = Boolean.FALSE;
        Company company = new Gson().fromJson(companyJson, Company.class);
        if(company != null){
            baseDao.update(company);
            saveCompany = Boolean.TRUE;
            return gson.toJson(saveCompany);
        }
        String json = gson.toJson(saveCompany);
        LOGGER.debug("Could not save the Company Objects");
        return json;
    }

    @GET
    @Path("/whitelist/{mid}/{tierId}")
    @Produces("application/json")
    public String whiteListCompany(@PathParam("mid") String mid, @PathParam("tierId") String tierId){
        Gson gson = new Gson();
        Boolean retValue = Boolean.FALSE;
        try {
            Integer intMid = Integer.parseInt(mid);
            Company company = companyDao.getCompanyByMID(intMid);
            company.setTierId(Integer.parseInt(tierId));
            baseDao.update(company);
            retValue = Boolean.TRUE;
        } catch (Exception e){
            LOGGER.error("Exception while WhiteListing a company");
            throw new TMMarketPlaceDatabaseException("Exception while WhiteListing a company");
        }
        return gson.toJson(retValue);
    }

}
