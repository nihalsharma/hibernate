package com.tm.mid.client.service;

import com.tm.mid.client.exception.TMMIDConversionException;
import com.tm.mid.client.exception.TMMIDServiceInaccessible;
import com.tm.mid.client.pojo.*;
import com.tm.mid.client.utils.ClientUtil;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;

/**
 * Created by Nihal on 9/16/14.
 */
public class MarketPlaceGetterClient {

    private final ResteasyClient client;
    private final String baseUrl;
    private final ClientUtil clientUtil;

    public MarketPlaceGetterClient(String url) {
        baseUrl = url;
        client = new ResteasyClientBuilder().build();
        clientUtil = new ClientUtil();
    }

    public Company getCompanyByMid(int mid) {
        try {
            String result = getResponseString(baseUrl + "get/companyByMid/" + mid);
            Company company = clientUtil.getObjectFromJson(Company.class, result);
            return company;
        } catch (Exception e) {

        }
        return null;
    }

    public Company getCompanyById(int mid) {
        try {
            String result = getResponseString(baseUrl + "get/companyById/" + mid);
            Company company = clientUtil.getObjectFromJson(Company.class, result);
            return company;
        } catch (Exception e) {

        }
        return null;
    }

    public User getUserById(int id) {
        try {
            String result = getResponseString(baseUrl + "get/userById/" + id);
            User user = clientUtil.getObjectFromJson(User.class, result);
            return user;
        } catch (Exception e) {

        }
        return null;
    }

    public int getCompanyCount() {
        try {
            String result = getResponseString(baseUrl + "get/companyCount");
            int user = clientUtil.getObjectFromJson(Integer.class, result);
            return user;
        } catch (Exception e) {

        }
        return 0;
    }

    public int getUserCount() {
        try {
            String result = getResponseString(baseUrl + "get/userCount");
            int user = clientUtil.getObjectFromJson(Integer.class, result);
            return user;
        } catch (Exception e) {

        }
        return 0;
    }

    public HashMap<Integer, String> getAllWhiteListedCompanies() {
        try {
            String result = getResponseString(baseUrl + "get/whiteListedCompanies");
            HashMap<Integer, String> companies = clientUtil.getMapFromJson(result);
            return companies;
        } catch (Exception e) {

        }
        return null;
    }


    public List<WidgetType> getAllWidgets() {
        try {
            String result = getResponseString(baseUrl + "get/allWidgets");
            List<WidgetType> widgets = clientUtil.getListFromJson(WidgetType.class, result);
            return widgets;
        } catch (Exception e) {

        }
        return null;
    }

    public WidgetType getWidgetById(int wid) {
        try {
            String result = getResponseString(baseUrl + "get/widgetById" + wid);
            WidgetType widgetType = clientUtil.getObjectFromJson(WidgetType.class, result);
            return widgetType;
        } catch (Exception e) {

        }
        return null;
    }

    public List<WidgetType> getWidgetsForCompany(int mid) {
        try {
            String result = getResponseString(baseUrl + "get/widgetByCompany" + mid);
            List<WidgetType> widgets = clientUtil.getListFromJson(WidgetType.class, result);
            return widgets;
        } catch (Exception e) {

        }
        return null;
    }


    public List<Company> getCompanyListByUserId(int uid) {
        try {
            String result = getResponseString(baseUrl + "get/companyByUserId" + uid);
            List<Company> companies = clientUtil.getListFromJson(Company.class, result);
            return companies;
        } catch (Exception e) {

        }
        return null;
    }

    public List<CompanyCategoryMap> getCompanyCategoryMapMid(int mid) {
        try {
            String result = getResponseString(baseUrl + "get/companyCategoryMap" + mid);
            List<CompanyCategoryMap> categoryMapList = clientUtil.getListFromJson(CompanyCategoryMap.class, result);
            return categoryMapList;
        } catch (Exception e) {

        }
        return null;
    }

    public List<CompanyCategoryMap> getAllCompanyCategoryMap() {
        try {
            String result = getResponseString(baseUrl + "get/allCompanyCategoryMap");
            List<CompanyCategoryMap> categoryMapList = clientUtil.getListFromJson(CompanyCategoryMap.class, result);
            return categoryMapList;
        } catch (Exception e) {

        }
        return null;
    }

    public List<TMWRSClient> allTMWRSClients() {
        try {
            String result = getResponseString(baseUrl + "get/allTMWRSClients");
            List<TMWRSClient> tmwrsClients = clientUtil.getListFromJson(TMWRSClient.class, result);
            return tmwrsClients;
        } catch (Exception e) {

        }
        return null;
    }

    public TMWRSClient getTMWRSClientByMid(int mid) {
        try {
            String result = getResponseString(baseUrl + "get/tmwrsClientByMID/" + mid);
            TMWRSClient client = clientUtil.getObjectFromJson(TMWRSClient.class, result);
            return client;
        } catch (Exception e) {

        }
        return null;
    }

    private String getResponseString(String url) {
        try {
            ResteasyWebTarget target = client.target(url);
            Response response = target.request().get();
            return response.readEntity(String.class);
        } catch (Exception e) {
            throw new TMMIDServiceInaccessible(e.getMessage(), e.getCause());
        }
    }

    

}
