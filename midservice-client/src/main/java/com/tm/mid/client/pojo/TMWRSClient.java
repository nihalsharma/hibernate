package com.tm.mid.client.pojo;

/**
 * Created by Nihal on 9/16/14.
 * <p/>
 * This class is the mapping class of TMWRSClient class in the MID Service. ALl the field are mapped with the same
 * name. Any changes to the class in service should be implemented here also.
 */

public class TMWRSClient {

    private Integer id;
    private boolean urlFilterDisabled;
    private boolean recFilterDisabled;
    private int rhfRecWidgetId;
    private int pprRecWidgetId;
    private int mid;
    private int tierId;
    private String widgetFiles;
    private String productUrlPattern;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMWRSClient that = (TMWRSClient) o;

        if (mid != that.mid) return false;
        if (!id.equals(that.id)) return false;

        return true;
    }

}
