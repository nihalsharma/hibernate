package com.tm.midservice.db.dto;

import java.io.Serializable;

/**
 * Created by Nihal on 9/13/14.
 */
public class Tier implements Serializable {

    private Integer id;
    private String name;

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
}
