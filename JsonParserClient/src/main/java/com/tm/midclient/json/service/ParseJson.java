package com.tm.midclient.json.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tm.midclient.json.pojo.Company;
import com.tm.midclient.json.pojo.CompanyCategoryMap;
import com.tm.midclient.json.pojo.User;
import com.tm.midclient.json.pojo.WidgetType;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Nihal on 9/16/14.
 */
public class ParseJson {


    public Company getCompanyFromJson(String json) {
        try {
            if (json != null || json != "") {
                Gson gson = new Gson();
                Company company = gson.fromJson(json, Company.class);
                return company;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public User getUserFromJson(String json) {
        try {
            if (json != null || json != "") {
                Gson gson = new Gson();
                User user = gson.fromJson(json, User.class);
                return user;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public WidgetType getWidgetFromJson(String json) {
        try {
            if (json != null || json != "") {
                Gson gson = new Gson();
                WidgetType widgetType = gson.fromJson(json, WidgetType.class);
                return widgetType;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public CompanyCategoryMap getCompanyCategoryMapFromJson(String json) {
        try {
            if (json != null || json != "") {
                Gson gson = new Gson();
                CompanyCategoryMap companyCategoryMap = gson.fromJson(json, CompanyCategoryMap.class);
                return companyCategoryMap;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Company> getCompanyListFromJson(String json) {
        try {
            if (json != null || json != "") {
                Gson gson = new Gson();
                Type token = new TypeToken<List<Company>>() {
                }.getType();
                List<Company> result = gson.fromJson(json, token);
                return result;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<User> getUserListFromJson(String json) {
        try {
            if (json != null || json != "") {
                Gson gson = new Gson();
                Type token = new TypeToken<List<User>>() {
                }.getType();
                List<User> result = gson.fromJson(json, token);
                return result;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<WidgetType> getWidgetListFromJson(String json) {
        try {
            if (json != null || json != "") {
                Gson gson = new Gson();
                Type token = new TypeToken<List<WidgetType>>() {
                }.getType();
                List<WidgetType> result = gson.fromJson(json, token);
                return result;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<CompanyCategoryMap> getCompanyCategoryMapListFromJson(String json) {
        try {
            if (json != null || json != "") {
                Gson gson = new Gson();
                Type token = new TypeToken<List<CompanyCategoryMap>>() {
                }.getType();
                List<CompanyCategoryMap> result = gson.fromJson(json, token);
                return result;
            }
        } catch (Exception e) {

        }
        return null;
    }




}
