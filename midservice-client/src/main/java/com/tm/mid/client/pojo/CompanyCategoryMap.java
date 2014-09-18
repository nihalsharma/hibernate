package com.tm.mid.client.pojo;

/**
 * Created by BigP on 9/16/14.
 */
public class CompanyCategoryMap {

    private Integer id;
    private int mid;
    private String catKey;
    private String catValue;
    private int priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getCatKey() {
        return catKey;
    }

    public void setCatKey(String catKey) {
        this.catKey = catKey;
    }

    public String getCatValue() {
        return catValue;
    }

    public void setCatValue(String catValue) {
        this.catValue = catValue;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "CompanyCategoryMap{" +
                "id=" + id +
                ", mid=" + mid +
                ", catKey='" + catKey + '\'' +
                ", catValue='" + catValue + '\'' +
                ", priority=" + priority +
                '}' + "\n" ;
    }
}
