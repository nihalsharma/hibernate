package com.tm.mid.client.service;

import com.tm.mid.client.exception.TMMIDConversionException;
import com.tm.mid.client.exception.TMMIDServiceInaccessible;
import com.tm.mid.client.pojo.*;
import com.tm.mid.client.utils.JSONUtil;
import com.tm.mid.client.utils.WebUtil;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Nihal on 9/16/14.
 */
public class MarketPlaceInfoClientImpl implements MarketPlaceInfoClient {

    private final ResteasyClient client;
    private final String baseUrl;
    private final JSONUtil jsonUtil;

    public MarketPlaceInfoClientImpl(String url) {
        baseUrl = url;
        client = new ResteasyClientBuilder().build();
        jsonUtil = new JSONUtil();
    }

    @Override
    public Company getCompanyByMid(int mid) throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/company-by-mid/" + mid, this.client);
        Company company = jsonUtil.getObjectFromJson(Company.class, result);
        return company;
    }

    @Override
    public Company getCompanyById(int mid) throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/company-by-id/" + mid, this.client);
        Company company = jsonUtil.getObjectFromJson(Company.class, result);
        return company;
    }

    @Override
    public User getUserById(int id) throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/user-by-id/" + id, this.client);
        User user = jsonUtil.getObjectFromJson(User.class, result);
        return user;
    }

    @Override
    public int getCompanyCount() throws TMMIDConversionException, TMMIDServiceInaccessible {
        String result = WebUtil.getResponseString(baseUrl + "get/company-count", this.client);
        int user = jsonUtil.getObjectFromJson(Integer.class, result);
        return user;
    }

    @Override
    public int getUserCount() throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/user-count", this.client);
        int user = jsonUtil.getObjectFromJson(Integer.class, result);
        return user;
    }

    @Override
    public List<Integer> getAllWhiteListedCompanies() throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/white-listed-companies", this.client);
        //HashMap<Integer, String> companies = jsonUtil.getMapFromJson(result);
        List<Integer> whiteListedCompanies = jsonUtil.getListFromJson(Integer.class, result);
        return whiteListedCompanies;
    }


    @Override
    public List<WidgetType> getAllWidgets() throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/all-widgets", this.client);
        List<WidgetType> widgets = jsonUtil.getListFromJson(WidgetType.class, result);
        return widgets;
    }

    @Override
    public WidgetType getWidgetById(int wid) throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/widget-by-id/" + wid, this.client);
        WidgetType widgetType = jsonUtil.getObjectFromJson(WidgetType.class, result);
        return widgetType;
    }

    @Override
    public List<WidgetType> getWidgetsForCompany(int mid) throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/widget-by-company-mid/" + mid, this.client);
        List<WidgetType> widgets = jsonUtil.getListFromJson(WidgetType.class, result);
        return widgets;
    }


    @Override
    public List<Company> getCompanyListByUserId(int uid) throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/company-by-user-id/" + uid, this.client);
        List<Company> companies = jsonUtil.getListFromJson(Company.class, result);
        return companies;
    }

    @Override
    public List<CompanyCategoryMap> getCompanyCategoryMapMid(int mid) throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/company-category-map/" + mid, this.client);
        List<CompanyCategoryMap> categoryMapList = jsonUtil.getListFromJson(CompanyCategoryMap.class, result);
        return categoryMapList;
    }

    @Override
    public List<CompanyCategoryMap> getAllCompanyCategoryMap() throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/all-company-category-map", this.client);
        List<CompanyCategoryMap> categoryMapList = jsonUtil.getListFromJson(CompanyCategoryMap.class, result);
        return categoryMapList;
    }

    @Override
    public List<CompanyAttributes> allCompanyAttributes() throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/all-company-attributes", this.client);
        List<CompanyAttributes> companyAttribues = jsonUtil.getListFromJson(CompanyAttributes.class, result);
        return companyAttribues;
    }

    @Override
    public CompanyAttributes getCompanyAttributesByMid(int mid) throws TMMIDServiceInaccessible, TMMIDConversionException {
        String result = WebUtil.getResponseString(baseUrl + "get/company-attributes-by-mid/" + mid, this.client);
        CompanyAttributes client = jsonUtil.getObjectFromJson(CompanyAttributes.class, result);
        return client;
    }

}
