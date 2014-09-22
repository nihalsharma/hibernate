package com.tm.midservice.db.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;

/**
 * Created by BigP on 9/16/14.
 */
@Entity
@Table(name = "company_category_mapping")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CompanyCategoryMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "mid", nullable = false)
    private int mid;

    @Column(name = "category_key")
    private String catKey;

    @Column(name = "category_value")
    private String catValue;

    @Column(name = "priority")
    private Double priority;

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

    public Double getPriority() {
        return priority;
    }

    public void setPriority(Double priority) {
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
