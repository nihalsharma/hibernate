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
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private final BaseDao baseDao;
    private final UserDao userDao;
    private final CompanyDao companyDao;
    private final ObjectMapper mapper;

    public TMMarketPlaceGetResource() {
        baseDao = new BaseDaoImpl();
        companyDao = new CompanyDaoImpl();
        userDao = new UserDaoImpl();

        mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        mapper.setDateFormat(df);
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
    public String getCompanyById(@PathParam("id") String id){
        
        int intId = Integer.parseInt(id);
        Company company = baseDao.get(Company.class, intId);
        try {
            String json  = mapper.writeValueAsString(company);
            LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @GET
    @Path("/companyByMid/{mid}")
    @Produces("application/json")
    public String getCompanyByMid(@PathParam("mid") String mid) throws IOException {
        int intId = Integer.parseInt(mid);
        Company company = companyDao.getCompanyByMID(intId);
        String json = mapper.writeValueAsString(company);
        LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);
        return json;
    }

    @GET
    @Path("/tmwrsClientByMID/{mid}")
    @Produces("application/json")
    public String getTMWRSClientByMid(@PathParam("mid") String id){
        
        int intId = Integer.parseInt(id);
        TMWRSClient tmwrsClient = companyDao.getTMWRSClientByMid(intId);
        String json = null;
        try {
            json = mapper.writeValueAsString(tmwrsClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);
        return json;
    }

    @GET
    @Path("/allTMWRSClients")
    @Produces("application/json")
    public String getAllTMWRSClients(){
        List<TMWRSClient> tmwrsClient = companyDao.getAllTMWRSClients();
        String json = null;
        try {
            json = mapper.writeValueAsString(tmwrsClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);
        return json;
    }

    @GET
    @Path("/companyBySize/{start}/{size}")
    @Produces("application/json")
    public String getCompanyByMid(@PathParam("start") String start, @PathParam("size") String size){
        try {
            int startValue = Integer.parseInt(start);
            int endValue = Integer.parseInt(size);
            List<Company> companies = companyDao.getCompanyInRange(startValue, endValue);
            String json = mapper.writeValueAsString(companies);
            LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);

            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/userBySize/{start}/{size}")
    @Produces("application/json")
    public String getUserByMid(@PathParam("start") String start, @PathParam("size") String size){
        String json = null;
        try {
            int startValue = Integer.parseInt(start);
            int endValue = Integer.parseInt(size);
            List<User> users = userDao.getUserInRange(startValue, endValue);
            json = mapper.writeValueAsString(users);
            LOGGER.debug("Returning JSON from method: getUserByMid - " + json);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @GET
    @Path("/userById/{id}")
    @Produces("application/json")
    public String getUserById(@PathParam("id") String id){
        String json = null;
        try {
            int intId = Integer.parseInt(id);
            User user = baseDao.get(User.class, intId);
            json = mapper.writeValueAsString(user);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Returning JSON from method: getUserById - " + json);
        return json;
    }

    @GET
    @Path("/companyCount")
    @Produces("application/json")
    public String getCompanyCount(){
        int count  = 0;
        try {
            count = baseDao.getTotalCount(Company.class);
            String json = mapper.writeValueAsString(count);
            LOGGER.debug("Returning count from method: getCompanyCount - " + json);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(count);
    }

    @GET
    @Path("/userCount")
    @Produces("application/json")
    public String getUserCount(){
        int count  = 0;
        try {
            count = baseDao.getTotalCount(User.class);
            String json = mapper.writeValueAsString(count);
            LOGGER.debug("Returning count from method: getUserCount - " + json);
            return mapper.writeValueAsString(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(count);
    }

    @GET
    @Path("/whiteListedCompanies/")
    @Produces("application/json")
    public String getWhiteListedCompanies(){
        List<Company> companies = companyDao.getWhiteListedCompanies();
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        for (Company company : companies) {
            hashMap.put(company.getMid(), company.getName());
        }
        try {
            return mapper.writeValueAsString(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/allWidgets")
    @Produces("application/json")
    public String getAllWidgets(){
        List<WidgetType> widgetTypes = EnumWidgetType.getAll();
        try {
            return mapper.writeValueAsString(widgetTypes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/widgetById/{wid}")
    @Produces("application/json")
    public String getWidgetById(@PathParam("wid") String wid){
        
        WidgetType widget = EnumWidgetType.getById(Integer.parseInt(wid)).asWidgetType();
        if(widget != null) {
            try {
                return mapper.writeValueAsString(widget);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    @GET
    @Path("/widgetByCompany/{mid}")
    @Produces("application/json")
    public String getWidgetForCompany(@PathParam("mid") String mid){
        
        int companyMid = Integer.parseInt(mid);
        Company company = companyDao.getCompanyByMID(companyMid);
        List<WidgetType> widgetTypes = new ArrayList<WidgetType>();
        if(company != null) {
            try {
                EnumSet<EnumWidgetType> widgetTypeEnumSet = EnumTierType.getWidgetSetByTierId(company.getTierId());
                for (EnumWidgetType enumWidgetType : widgetTypeEnumSet) {
                    widgetTypes.add(enumWidgetType.asWidgetType());
                }
                return mapper.writeValueAsString(widgetTypes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    @GET
    @Path("/companyByUserId/{uid}")
    @Produces("application/json")
    public String getCompanyByUserId(@PathParam("uid") String uid){
        
        int intId = Integer.parseInt(uid);
        List<Company> company = companyDao.getCompanyByUserId(intId);
        if(company != null && company.size() > 0) {
            String json = null;
            try {
                json = mapper.writeValueAsString(company);
            } catch (IOException e) {
                e.printStackTrace();
            }
            LOGGER.debug("Returning JSON from method: getCompanyByUserId - " + json);
            return json;
        }
        return "";
    }


    @GET
    @Path("/companyCategoryMap/{mid}")
    @Produces("application/json")
    public String getCompanyCategoryMapByMid(@PathParam("mid") String mid){
        
        int intId = Integer.parseInt(mid);
        List<CompanyCategoryMap> company = companyDao.getCompanyCategoryMapByMid(intId);
        if(company != null && company.size() > 0) {
            String json = null;
            try {
                json = mapper.writeValueAsString(company);
            } catch (IOException e) {
                e.printStackTrace();
            }
            LOGGER.debug("Returning JSON from method: getCompanyCategoryMap - " + json);
            return json;
        }
        return "";
    }

    @GET
    @Path("/allCompanyCategoryMap")
    @Produces("application/json")
    public String getAllCompanyCategoryMap(){
        try {
            List<CompanyCategoryMap> company = companyDao.getAllCompanyCategoryMap();
            if(company != null && company.size() > 0) {
                String json = mapper.writeValueAsString(company);
                LOGGER.debug("Returning JSON from method: getCompanyCategoryMap - " + json);
                return json;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
