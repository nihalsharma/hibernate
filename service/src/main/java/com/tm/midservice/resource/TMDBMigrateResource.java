package com.tm.midservice.resource;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.tm.midservice.db.core.DataBaseManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Nihal on 9/12/14.
 */
@Path("/updatedb")
public class TMDBMigrateResource {

    @GET
    @Path("/migrate")
    @Produces("application/json")
    public String doDBMigrate(){
        Gson gson = new Gson();
        Connection connection = DataBaseManager.getConnection();
        boolean migrated  = DataBaseManager.executeBulkQuery(connection);
        return gson.toJson(migrated);
    }
}
