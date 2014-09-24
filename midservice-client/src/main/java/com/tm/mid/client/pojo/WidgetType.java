package com.tm.mid.client.pojo;

/**
 * Created by BigP on 9/16/14.
 */
public class WidgetType {

    private Integer id;
    private String name;
    private int tier;

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
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
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
