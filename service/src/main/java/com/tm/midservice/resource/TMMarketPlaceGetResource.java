package com.tm.midservice.resource;

import com.google.gson.Gson;
import com.tm.midservice.db.constants.EnumTierType;
import com.tm.midservice.db.constants.EnumWidgetType;
import com.tm.midservice.db.dto.User;
import com.tm.midservice.db.impl.BaseDaoImpl;
import com.tm.midservice.db.impl.CompanyDaoImpl;
import com.tm.midservice.db.impl.UserDaoImpl;
import com.tm.midservice.db.service.BaseDao;
import com.tm.midservice.db.dto.*;
import com.tm.midservice.db.service.CompanyDao;
import com.tm.midservice.db.service.UserDao;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nihal on 9/10/14.
 */
@Path("/get")
public class TMMarketPlaceGetResource {

    private static final Logger LOGGER = Logger.getLogger(TMMarketPlaceGetResource.class);
    private static BaseDao baseDao;
    private static UserDao userDao;
    private static CompanyDao companyDao;

    public TMMarketPlaceGetResource() {
        baseDao = new BaseDaoImpl();
        companyDao = new CompanyDaoImpl();
        userDao = new UserDaoImpl();
    }

    @GET
    @Path("/testAPI")
    @Produces("application/json")
    public String testService(){
        return "I am healthy !!!";
    }

    @GET
    @Path("/companyById/{id}")
    @Produces("application/json")
    public String getCompanyByMid(@PathParam("id") String id){
        Gson gson = new Gson();
        int intId = Integer.parseInt(id);
        Company company = baseDao.get(Company.class, intId);
        String json = gson.toJson(company);
        LOGGER.debug("Returning JSOn from method: getCompanyByMid - " + json);
        return json;
    }

    @GET
    @Path("/companyBySize/{start}/{size}")
    @Produces("application/json")
    public String getCompanyByMid(@PathParam("start") String start, @PathParam("size") String size){
        Gson gson = new Gson();
        int startValue = Integer.parseInt(start);
        int endValue = Integer.parseInt(size);
        List<Company> companies = companyDao.getCompanyInRange(startValue, endValue);
        String json = gson.toJson(companies);
        LOGGER.debug("Returning JSOn from method: getCompanyByMid - " + json);
        return json;
    }

    @GET
    @Path("/userBySize/{start}/{size}")
    @Produces("application/json")
    public String getUserByMid(@PathParam("start") String start, @PathParam("size") String size){
        Gson gson = new Gson();
        int startValue = Integer.parseInt(start);
        int endValue = Integer.parseInt(size);
        List<User> users = userDao.getUserInRange(startValue, endValue);
        String json = gson.toJson(users);
        LOGGER.debug("Returning JSOn from method: getUserByMid - " + json);
        return json;
    }

    @GET
    @Path("/userById/{id}")
    @Produces("application/json")
    public String getUserById(@PathParam("id") String id){
        Gson gson = new Gson();
        int intId = Integer.parseInt(id);
        User user = baseDao.get(User.class, intId);
        String json = gson.toJson(user);
        LOGGER.debug("Returning JSOn from method: getUserById - " + json);
        return json;
    }

    @GET
    @Path("/companyCount")
    @Produces("application/json")
    public String getCompanyCount(){
        int count  = 0;
        Gson gson = new Gson();
        count = baseDao.getTotalCount(Company.class);
        String json = gson.toJson(count);
        LOGGER.debug("Returning count from method: getCompanyCount - " + json);
        return json;
    }

    @GET
    @Path("/userCount")
    @Produces("application/json")
    public String getUserCount(){
        int count  = 0;
        Gson gson = new Gson();
        count = baseDao.getTotalCount(User.class);
        String json = gson.toJson(count);
        LOGGER.debug("Returning count from method: getUserCount - " + json);
        return json;
    }

    @GET
    @Path("/whiteListedCompanies/")
    @Produces("application/json")
    public String getWhiteListedCompanies(){
        Gson gson = new Gson();
        List<Company> companies = companyDao.getWhiteListedCompanies();
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        for (Company company : companies) {
            hashMap.put(company.getMid(), company.getName());
        }
        return gson.toJson(hashMap);
    }

    @GET
    @Path("/allWidgets")
    @Produces("application/json")
    public String getAllWidgets(){
        Gson gson = new Gson();
        List<WidgetType> widgetTypes = EnumWidgetType.getAll();
        return gson.toJson(widgetTypes);
    }

    @GET
    @Path("/widgetById/{wid}")
    @Produces("application/json")
    public String getWidgetById(@PathParam("wid") String wid){
        Gson gson = new Gson();
        WidgetType widget = EnumWidgetType.getById(Integer.parseInt(wid)).asWidgetType();
        if(widget != null) {
            return gson.toJson(widget);
        }
        return gson.toJson("");
    }


    @GET
    @Path("/widgetByCompany/{mid}")
    @Produces("application/json")
    public String getWidgetForCompany(@PathParam("mid") String mid){
        Gson gson = new Gson();
        int companyMid = Integer.parseInt(mid);
        Company company = companyDao.getCompanyByMID(companyMid);
        List<WidgetType> widgetTypes = new ArrayList<WidgetType>();
        if(company != null) {
            EnumSet<EnumWidgetType> widgetTypeEnumSet = EnumTierType.getWidgetSetByTierId(company.getTieId());
            for (EnumWidgetType enumWidgetType : widgetTypeEnumSet) {
                widgetTypes.add(enumWidgetType.asWidgetType());
            }
        }
        return gson.toJson(widgetTypes);
    }

    @GET
    @Path("/companyByUserId/{uid}")
    @Produces("application/json")
    public String getCompanyByUserId(@PathParam("uid") String uid){
        Gson gson = new Gson();
        int intId = Integer.parseInt(uid);
        List<Company> company = companyDao.getCompanyByUserId(intId);
        if(company != null && company.size() > 0) {
            String json = gson.toJson(company);
            LOGGER.debug("Returning JSOn from method: getCompanyByUserId - " + json);
            return json;
        }
        return gson.toJson("");
    }


    @GET
    @Path("/companyCategoryMap/{mid}")
    @Produces("application/json")
    public String getCompanyCategoryMapByMid(@PathParam("mid") String mid){
        Gson gson = new Gson();
        int intId = Integer.parseInt(mid);
        List<CompanyCategoryMap> company = companyDao.getCompanyCategoryMapByMid(intId);
        if(company != null && company.size() > 0) {
            String json = gson.toJson(company);
            LOGGER.debug("Returning JSOn from method: getCompanyCategoryMap - " + json);
            return json;
        }
        return gson.toJson("");
    }

    @GET
    @Path("/allCompanyCategoryMap")
    @Produces("application/json")
    public String getAllCompanyCategoryMap(){
        Gson gson = new Gson();
        List<CompanyCategoryMap> company = companyDao.getAllCompanyCategoryMap();
        if(company != null && company.size() > 0) {
            String json = gson.toJson(company);
            LOGGER.debug("Returning JSOn from method: getCompanyCategoryMap - " + json);
            return json;
        }
        return gson.toJson("");
    }


}
