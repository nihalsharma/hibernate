package com.tm.midservice.resource;

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
import com.tm.midservice.exception.TMMarketPlaceServiceException;
import org.apache.log4j.Logger;
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
    @Path("/test-api")
    @Produces("application/json")
    public String testService(){
        return "I am healthy !!!";
    }

    @GET
    @Path("/company-by-id/{id}")
    @Produces("application/json")
    public String getCompanyById(@PathParam("id") String id) throws TMMarketPlaceServiceException {
        
        int intId = Integer.parseInt(id);
        Company company = baseDao.get(Company.class, intId);
        try {
            String json  = mapper.writeValueAsString(company);
            LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);
            return json;
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
    }


    @GET
    @Path("/company-by-mid/{mid}")
    @Produces("application/json")
    public String getCompanyByMid(@PathParam("mid") String mid) throws IOException {
        int intId = Integer.parseInt(mid);
        Company company = companyDao.getCompanyByMID(intId);
        String json = mapper.writeValueAsString(company);
        LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);
        return json;
    }

    @GET
    @Path("/company-attributes-by-mid/{mid}")
    @Produces("application/json")
    public String getTMWRSClientByMid(@PathParam("mid") String id) throws TMMarketPlaceServiceException {
        
        int intId = Integer.parseInt(id);
        CompanyAttributes companyAttributes = companyDao.getCompanyAttributesByMid(intId);
        String json = null;
        try {
            json = mapper.writeValueAsString(companyAttributes);
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
        LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);
        return json;
    }

    @GET
    @Path("/all-company-attributes")
    @Produces("application/json")
    public String getAllTMWRSClients() throws TMMarketPlaceServiceException {
        List<CompanyAttributes> companyAttributes = companyDao.getAllCompanyAttributes();
        String json = null;
        try {
            json = mapper.writeValueAsString(companyAttributes);
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
        LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);
        return json;
    }

    @GET
    @Path("/company-by-size/{start}/{size}")
    @Produces("application/json")
    public String getCompanyByMid(@PathParam("start") String start, @PathParam("size") String size) throws TMMarketPlaceServiceException {
        try {
            int startValue = Integer.parseInt(start);
            int endValue = Integer.parseInt(size);
            List<Company> companies = companyDao.getCompanyInRange(startValue, endValue);
            String json = mapper.writeValueAsString(companies);
            LOGGER.debug("Returning JSON from method: getCompanyByMid - " + json);

            return json;
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
    }

    @GET
    @Path("/user-by-size/{start}/{size}")
    @Produces("application/json")
    public String getUserByMid(@PathParam("start") String start, @PathParam("size") String size) throws TMMarketPlaceServiceException {
        String json = null;
        try {
            int startValue = Integer.parseInt(start);
            int endValue = Integer.parseInt(size);
            List<User> users = userDao.getUserInRange(startValue, endValue);
            json = mapper.writeValueAsString(users);
            LOGGER.debug("Returning JSON from method: getUserByMid - " + json);
            return json;
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
    }

    @GET
    @Path("/user-by-id/{id}")
    @Produces("application/json")
    public String getUserById(@PathParam("id") String id) throws TMMarketPlaceServiceException {
        String json = null;
        try {
            int intId = Integer.parseInt(id);
            User user = baseDao.get(User.class, intId);
            json = mapper.writeValueAsString(user);
            return json;
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
    }

    @GET
    @Path("/company-count")
    @Produces("application/json")
    public String getCompanyCount() throws TMMarketPlaceServiceException {
        int count  = 0;
        try {
            count = baseDao.getTotalCount(Company.class);
            String json = mapper.writeValueAsString(count);
            LOGGER.debug("Returning count from method: getCompanyCount - " + json);
            return json;
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
    }

    @GET
    @Path("/user-count")
    @Produces("application/json")
    public String getUserCount() throws TMMarketPlaceServiceException {
        int count  = 0;
        try {
            count = baseDao.getTotalCount(User.class);
            String json = mapper.writeValueAsString(count);
            LOGGER.debug("Returning count from method: getUserCount - " + json);
            return mapper.writeValueAsString(json);
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
    }

    @GET
    @Path("/white-listed-companies/")
    @Produces("application/json")
    public String getWhiteListedCompanies() throws TMMarketPlaceServiceException {
        List<Company> companies = companyDao.getWhiteListedCompanies();
        List<Integer> midList = new ArrayList<>();
        for (Company company : companies) {
            midList.add(company.getMid());
        }
        try {
            return mapper.writeValueAsString(midList);
        } catch (IOException e) {
            throw new TMMarketPlaceServiceException(e, e.getMessage());
        }
    }

    @GET
    @Path("/all-widgets")
    @Produces("application/json")
    public String getAllWidgets() throws TMMarketPlaceServiceException {
        List<WidgetType> widgetTypes = EnumWidgetType.getAll();
        try {
            return mapper.writeValueAsString(widgetTypes);
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
    }

    @GET
    @Path("/widget-by-id/{wid}")
    @Produces("application/json")
    public String getWidgetById(@PathParam("wid") String wid) throws TMMarketPlaceServiceException {
        
        WidgetType widget = EnumWidgetType.getById(Integer.parseInt(wid)).asWidgetType();
        if(widget != null) {
            try {
                return mapper.writeValueAsString(widget);
            } catch (IOException e) {
                throw new  TMMarketPlaceServiceException(e, e.getMessage());
            }
        }
        return "";
    }


    @GET
    @Path("/widget-by-company-mid/{mid}")
    @Produces("application/json")
    public String getWidgetForCompany(@PathParam("mid") String mid) throws TMMarketPlaceServiceException {
        
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
                throw new  TMMarketPlaceServiceException(e, e.getMessage());
            }
        }
        return "";
    }

    @GET
    @Path("/company-by-user-id/{uid}")
    @Produces("application/json")
    public String getCompanyByUserId(@PathParam("uid") String uid) throws TMMarketPlaceServiceException {
        
        int intId = Integer.parseInt(uid);
        List<Company> company = companyDao.getCompanyByUserId(intId);
        if(company != null && company.size() > 0) {
            String json = null;
            try {
                json = mapper.writeValueAsString(company);
            } catch (IOException e) {
                throw new  TMMarketPlaceServiceException(e, e.getMessage());
            }
            LOGGER.debug("Returning JSON from method: getCompanyByUserId - " + json);
            return json;
        }
        return "";
    }


    @GET
    @Path("/company-category-map/{mid}")
    @Produces("application/json")
    public String getCompanyCategoryMapByMid(@PathParam("mid") String mid) throws TMMarketPlaceServiceException {
        
        int intId = Integer.parseInt(mid);
        List<CompanyCategoryMap> company = companyDao.getCompanyCategoryMapByMid(intId);
        if(company != null && company.size() > 0) {
            String json = null;
            try {
                json = mapper.writeValueAsString(company);
            } catch (IOException e) {
                throw new  TMMarketPlaceServiceException(e, e.getMessage());
            }
            LOGGER.debug("Returning JSON from method: getCompanyCategoryMap - " + json);
            return json;
        }
        return "";
    }

    @GET
    @Path("/all-company-category-map")
    @Produces("application/json")
    public String getAllCompanyCategoryMap() throws TMMarketPlaceServiceException {
        try {
            List<CompanyCategoryMap> company = companyDao.getAllCompanyCategoryMap();
            if(company != null && company.size() > 0) {
                String json = mapper.writeValueAsString(company);
                LOGGER.debug("Returning JSON from method: getCompanyCategoryMap - " + json);
                return json;
            }
        } catch (IOException e) {
            throw new  TMMarketPlaceServiceException(e, e.getMessage());
        }
        return "";
    }

}
