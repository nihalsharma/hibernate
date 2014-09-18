package com.tm.midservice.db.service;

import com.tm.midservice.db.dto.Company;
import com.tm.midservice.db.dto.CompanyCategoryMap;
import com.tm.midservice.db.dto.TMWRSClient;

import java.util.List;

/**
 * Created by Nihal on 9/11/14.
 */
public interface CompanyDao extends BaseDao{

    public List<Company> getCompanyInRange(int start, int size);

    public Company getCompanyByMID(int intMid);

    public List<Company> getWhiteListedCompanies();

    public List<Company> getCompanyByUserId(int userId);

    public List<CompanyCategoryMap> getCompanyCategoryMapByMid(int intId);

    public List<CompanyCategoryMap> getAllCompanyCategoryMap();



    /** Calls for Class TMWRSClient goes here**/

    public TMWRSClient getTMWRSClientByMid(int id);

    public List<TMWRSClient> getAllTMWRSClients();
}
