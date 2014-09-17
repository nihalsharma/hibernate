package com.tm.midservice.db.dto;

import javax.persistence.*;

/**
 * Created by BigP on 9/16/14.
 */
@Entity
@Table(name = "company_category_mapping")
public class CompanyCategoryMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "mid", nullable = false)
    private int mid;

    @Column(name = "category_mapping", nullable = false)
    private String mappingString;

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

    public String getMappingString() {
        return mappingString;
    }

    public void setMappingString(String mappingString) {
        this.mappingString = mappingString;
    }
}
