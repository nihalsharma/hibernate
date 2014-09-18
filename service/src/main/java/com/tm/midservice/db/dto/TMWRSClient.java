package com.tm.midservice.db.dto;

import javax.persistence.*;

/**
 * Created by Nihal on 9/17/14.
 */
@Entity
@Table(name = "tmwrs_client")
public class TMWRSClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name="is_url_filter_disabled")
    private boolean urlFilterDisabled;

    @Column(name="is_recs_filter_disabled")
    private boolean recFilterDisabled;

    @Column(name = "rhf_recs_widget_id")
    private int rhfRecWidgetId;

    @Column(name = "ppr_recs_widget_id")
    private int pprRecWidgetId;

    @Column(name = "mid")
    private int mid;

    @Column(name = "tier_id")
    private int tierId;

    @Column(name = "widget_files")
    private String widgetFiles;

    @Column(name = "product_url_pattern")
    private String productUrlPattern;

    @Column(name = "referrer_url_pattern")
    private String referrerUrlPattern;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isUrlFilterDisabled() {
        return urlFilterDisabled;
    }

    public void setUrlFilterDisabled(boolean urlFilterDisabled) {
        this.urlFilterDisabled = urlFilterDisabled;
    }

    public boolean isRecFilterDisabled() {
        return recFilterDisabled;
    }

    public void setRecFilterDisabled(boolean recFilterDisabled) {
        this.recFilterDisabled = recFilterDisabled;
    }

    public int getRhfRecWidgetId() {
        return rhfRecWidgetId;
    }

    public void setRhfRecWidgetId(int rhfRecWidgetId) {
        this.rhfRecWidgetId = rhfRecWidgetId;
    }

    public int getPprRecWidgetId() {
        return pprRecWidgetId;
    }

    public void setPprRecWidgetId(int pprRecWidgetId) {
        this.pprRecWidgetId = pprRecWidgetId;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getTierId() {
        return tierId;
    }

    public void setTierId(int tierId) {
        this.tierId = tierId;
    }

    public String getWidgetFiles() {
        return widgetFiles;
    }

    public void setWidgetFiles(String widgetFiles) {
        this.widgetFiles = widgetFiles;
    }

    public String getProductUrlPattern() {
        return productUrlPattern;
    }

    public void setProductUrlPattern(String productUrlPattern) {
        this.productUrlPattern = productUrlPattern;
    }

    public String getReferrerUrlPattern() {
        return referrerUrlPattern;
    }

    public void setReferrerUrlPattern(String referrerUrlPattern) {
        this.referrerUrlPattern = referrerUrlPattern;
    }

    @Override
    public String toString() {
        return "TMWRSClient{" +
                "id=" + id +
                ", urlFilterDisabled=" + urlFilterDisabled +
                ", recFilterDisabled=" + recFilterDisabled +
                ", rhfRecWidgetId=" + rhfRecWidgetId +
                ", pprRecWidgetId=" + pprRecWidgetId +
                ", mid=" + mid +
                ", tierId=" + tierId +
                ", widgetFiles='" + widgetFiles + '\'' +
                ", productUrlPattern='" + productUrlPattern + '\'' +
                ", referrerUrlPattern='" + referrerUrlPattern + '\'' +
                '}'+"\n";
    }
}
