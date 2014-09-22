package com.tm.midservice.db.impl;

import com.tm.midservice.db.dto.Company;
import com.tm.midservice.db.dto.CompanyAttributes;
import com.tm.midservice.db.dto.CompanyCategoryMap;
import com.tm.midservice.db.service.CompanyDao;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Nihal on 9/11/14.
 */
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {

    private static Logger LOGGER = Logger.getLogger(CompanyDaoImpl.class);


    @Override
    public List<Company> getCompanyInRange(int start, int size) {
        Query query = startOperation().createQuery("from Company c");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List companyList = query.list();
        return companyList;
    }

    @Override
    public Company getCompanyByMID(int intMid) {
        String hql = "from Company c where c.mid = :intMid";
        Query query = startOperation().createQuery(hql);
        query.setInteger("intMid", intMid);
        return (Company) query.uniqueResult();
    }

    @Override
    public List<Company> getWhiteListedCompanies() {
        String hql = "from Company c where c.tierId is not null";
        Query query = startOperation().createQuery(hql);
        List<Company> companies = query.list();
        return companies;
    }

    @Override
    public List<Company> getCompanyByUserId(int userId) {
        String hql = "from Company c where c.mid = :userId";
        Query query = startOperation().createQuery(hql);
        query.setInteger("userId", userId);
        return query.list();
    }

    @Override
    public List<CompanyCategoryMap> getCompanyCategoryMapByMid(int mid) {
        String hql = "from CompanyCategoryMap c where c.mid = :mid";
        Query query = startOperation().createQuery(hql);
        query.setInteger("mid", mid);
        return query.list();
    }

    @Override
    public List<CompanyCategoryMap> getAllCompanyCategoryMap() {
        String hql = "from CompanyCategoryMap c";
        Query query = startOperation().createQuery(hql);
        return query.list();
    }

    @Override
    public CompanyAttributes getCompanyAttributesByMid(int intMid) {
        String hql = "from CompanyAttributes c where c.mid = :intMid";
        Query query = startOperation().createQuery(hql);
        query.setInteger("intMid", intMid);
        return (CompanyAttributes) query.uniqueResult();
    }

    @Override
    public List<CompanyAttributes> getAllCompanyAttributes() {
        String hql = "from CompanyAttributes c";
        Query query = startOperation().createQuery(hql);
        return query.list();
    }

}
