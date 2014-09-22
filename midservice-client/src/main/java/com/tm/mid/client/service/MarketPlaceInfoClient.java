package com.tm.mid.client.service;

import com.tm.mid.client.exception.TMMIDConversionException;
import com.tm.mid.client.exception.TMMIDServiceInaccessible;
import com.tm.mid.client.pojo.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by BigP on 9/22/14.
 */
public interface MarketPlaceInfoClient {

    public Company getCompanyByMid(int mid) throws TMMIDServiceInaccessible, TMMIDConversionException;

    public Company getCompanyById(int mid) throws TMMIDServiceInaccessible, TMMIDConversionException;

    public User getUserById(int id) throws TMMIDServiceInaccessible, TMMIDConversionException;

    public int getCompanyCount() throws TMMIDConversionException, TMMIDServiceInaccessible;

    public int getUserCount()  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public List<Integer> getAllWhiteListedCompanies()  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public List<WidgetType> getAllWidgets()  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public WidgetType getWidgetById(int wid)  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public List<WidgetType> getWidgetsForCompany(int mid)  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public List<Company> getCompanyListByUserId(int uid)  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public List<CompanyCategoryMap> getCompanyCategoryMapMid(int mid)  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public List<CompanyCategoryMap> getAllCompanyCategoryMap()  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public List<CompanyAttributes> allCompanyAttributes()  throws TMMIDConversionException, TMMIDServiceInaccessible;

    public CompanyAttributes getCompanyAttributesByMid(int mid)  throws TMMIDConversionException, TMMIDServiceInaccessible;
}
