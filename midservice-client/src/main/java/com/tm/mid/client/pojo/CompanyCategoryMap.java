package com.tm.mid.client.pojo;


/**
 * Created by Nihal on 9/16/14.
 * <p/>
 * This class is the mapping class of CompanyCategoryMap class in the MID Service. ALl the field are mapped
 * with the same name. Any changes to the class in service should be implemented here also.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyCategoryMap that = (CompanyCategoryMap) o;

        if (mid != that.mid) return false;
        if (priority != that.priority) return false;
        if (!catKey.equals(that.catKey)) return false;
        if (!catValue.equals(that.catValue)) return false;
        if (!id.equals(that.id)) return false;

        return true;
    }

}
