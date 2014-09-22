package com.tm.midservice.db.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nihal on 9/10/14.
 */

@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "users_count")
    private Integer usersCount;

    @Column(name = "mid")
    private Integer mid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name="active")
    private boolean active;

    @Column(name="search_feature_enabled")
    private boolean searchFeatureEnabled;

    @Column(name="analytics_feature_enabled")
    private boolean analyticsFeatureEnabled;

    @Column(name = "currency")
    private String currency;

    @Column(name = "domain")
    private String domain;

    @Column(name = "source")
    private String source;

    @Column(name = "source_domain")
    private String sourceDomain;

    @Column(name = "tier_id")
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
}
