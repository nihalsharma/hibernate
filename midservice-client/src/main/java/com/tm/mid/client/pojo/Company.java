package com.tm.mid.client.pojo;

import com.tm.mid.client.json.CustomJsonDateDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nihal on 9/16/14.
 * <p/>
 * <p/>
 * <p/>
 * This class is the mapping class of Company class in the database Service. ALl the field are mapped with the same
 * name. Any changes to the class in service should be implemented here also.
 */
public class Company implements Serializable {

    private Integer id;
    private String name;
    private Integer usersCount;
    private Integer mid;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createdAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updatedAt;

    private boolean active;
    private boolean searchFeatureEnabled;
    private boolean analyticsFeatureEnabled;
    private String currency;
    private String domain;
    private String source;
    private String sourceDomain;
    private int tierId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isSearchFeatureEnabled() {
        return searchFeatureEnabled;
    }

    public void setSearchFeatureEnabled(boolean searchFeatureEnabled) {
        this.searchFeatureEnabled = searchFeatureEnabled;
    }

    public boolean isAnalyticsFeatureEnabled() {
        return analyticsFeatureEnabled;
    }

    public void setAnalyticsFeatureEnabled(boolean analyticsFeatureEnabled) {
        this.analyticsFeatureEnabled = analyticsFeatureEnabled;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceDomain() {
        return sourceDomain;
    }

    public void setSourceDomain(String sourceDomain) {
        this.sourceDomain = sourceDomain;
    }

    public int getTierId() {
        return tierId;
    }

    public void setTierId(int tierId) {
        this.tierId = tierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (!id.equals(company.id) || !mid.equals(company.mid)) return false;

        return true;
    }

}
