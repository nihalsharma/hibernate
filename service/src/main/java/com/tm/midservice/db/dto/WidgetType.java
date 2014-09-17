package com.tm.midservice.db.dto;

/**
 * Created by Nihal on 9/11/14.
 */

public class WidgetType {

    private Integer id;
    private String name;
    private int tierId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tierId;
    }

    public void setTier(int tierId) {
        this.tierId = tierId;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
