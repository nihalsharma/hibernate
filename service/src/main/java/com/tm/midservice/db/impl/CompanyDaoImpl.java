package com.tm.midservice.db.impl;

import com.tm.midservice.db.dto.Company;
import com.tm.midservice.db.dto.CompanyAttributes;
import com.tm.midservice.db.dto.CompanyCategoryMap;
import com.tm.midservice.db.service.CompanyDao;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nihal on 9/11/14.
 */
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {

    private static Logger LOGGER = Logger.getLogger(CompanyDaoImpl.class);


    @Override
    public List<Company> getCompanyInRange(final int start, final int size) {
        SessionOperationCallback<List> exec = new SessionOperationCallback<List>() {
            public List companyList;

            @Override
            public void execute(Session session) {
                Query query = session.createQuery("from Company c");
                query.setFirstResult(start);
                query.setMaxResults(size);
                companyList = query.list();
            }

            @Override
            public List get() {
                return companyList;
            }
        };
        executeOperation(exec);
        return exec.get();
    }

    @Override
    public Company getCompanyByMID(final int intMid) {
        SessionOperationCallback<Company> exec = new SessionOperationCallback<Company>() {
            public Company company;

            @Override
            public void execute(Session session) {
                String hql = "from Company c where c.mid = :intMid";
                Query query = session.createQuery(hql);
                query.setInteger("intMid", intMid);
                company = (Company) query.uniqueResult();
            }

            @Override
            public Company get() {
                return company;
            }
        };
        executeOperation(exec);
        return exec.get();
    }

    @Override
    public List<Company> getWhiteListedCompanies() {

        SessionOperationCallback<List<Company>> exec = new SessionOperationCallback<List<Company>>() {
            public List<Company> company;

            @Override
            public void execute(Session session) {
                String hql = "from Company c where c.tierId is not null";
                Query query = session.createQuery(hql);
                company = query.list();
            }

            @Override
            public List<Company> get() {
                return company;
            }
        };
        executeOperation(exec);
        return exec.get();
    }

    @Override
    public List<Company> getCompanyByUserId(final int userId) {

        SessionOperationCallback<List<Company>> execution = new SessionOperationCallback<List<Company>>() {
            public List<Company> companies;

            @Override
            public <T> void execute(Session session) {
                String hql = "from Company c where c.mid = :userId";
                Query query = session.createQuery(hql);
                query.setInteger("userId", userId);
                companies = query.list();
            }

            @Override
            public List<Company> get() {
                return companies;
            }
        };
        executeOperation(execution);
        return execution.get();
    }

    @Override
    public List<CompanyCategoryMap> getCompanyCategoryMapByMid(final int mid) {

        SessionOperationCallback<List<CompanyCategoryMap>> execution = new SessionOperationCallback<List<CompanyCategoryMap>>() {
            public List<CompanyCategoryMap> companies;

            @Override
            public <T> void execute(Session session) {
                String hql = "from CompanyCategoryMap c where c.mid = :mid";
                Query query = session.createQuery(hql);
                query.setInteger("mid", mid);
                companies = query.list();
            }

            @Override
            public List<CompanyCategoryMap> get() {
                return companies;
            }
        };
        executeOperation(execution);
        return execution.get();
    }

    @Override
    public List<CompanyCategoryMap> getAllCompanyCategoryMap() {

        SessionOperationCallback<List<CompanyCategoryMap>> execution = new SessionOperationCallback<List<CompanyCategoryMap>>() {
            public List<CompanyCategoryMap> companies;

            @Override
            public <T> void execute(Session session) {
                String hql = "from CompanyCategoryMap c";
                Query query = session.createQuery(hql);
                companies = query.list();
            }

            @Override
            public List<CompanyCategoryMap> get() {
                return companies;
            }
        };
        executeOperation(execution);
        return execution.get();
    }

    @Override
    public CompanyAttributes getCompanyAttributesByMid(final int intMid) {

        SessionOperationCallback<CompanyAttributes> execution = new SessionOperationCallback<CompanyAttributes>() {
            public CompanyAttributes companyAttributes;

            @Override
            public <T> void execute(Session session) {
                String hql = "from CompanyAttributes c where c.mid = :intMid";
                Query query = session.createQuery(hql);
                query.setInteger("intMid", intMid);
                companyAttributes = (CompanyAttributes) query.uniqueResult();
            }

            @Override
            public CompanyAttributes get() {
                return companyAttributes;
            }
        };
        executeOperation(execution);
        return execution.get();
    }

    @Override
    public List<CompanyAttributes> getAllCompanyAttributes() {

        SessionOperationCallback<List<CompanyAttributes>> execution = new SessionOperationCallback<List<CompanyAttributes>>() {
            public List<CompanyAttributes> companyAttributes;

            @Override
            public <T> void execute(Session session) {
                String hql = "from CompanyAttributes c";
                Query query = session.createQuery(hql);
                companyAttributes = (List<CompanyAttributes>) query.list();
            }

            @Override
            public List<CompanyAttributes> get() {
                return companyAttributes;
            }
        };
        executeOperation(execution);
        return execution.get();
    }

}
