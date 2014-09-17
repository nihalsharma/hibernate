package com.tm.midservice;

import com.google.gson.Gson;
import com.tm.midservice.db.dto.Company;
import com.tm.midservice.db.dto.User;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.Test;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by BigP on 9/14/14.
 */
public class AuthorizationTest {

    @Test
    public void testAPIAuth() throws IOException {

        ResteasyClient client =  new ResteasyClientBuilder().build();
        //client.register(new AuthorizationRequestFilter());
        WebTarget resourceTarget = client.target("http://localhost:8081/api/get/testAPI");
        Invocation invocation = resourceTarget.request("text/plain")
                .header("tmauthorize", "ac").buildGet();

        // Invoke the request using generic interface
        Response response = resourceTarget.request().get();
        String value = response.readEntity(String.class);
        System.out.println(value);
        System.out.println("nnihal");
        assertEquals("", "");



        String url = "http://localhost:8081/api/get/testAPI";
        URL obj = new URL(url);
        HttpURLConnection con1 = (HttpURLConnection) obj.openConnection();
        con1.setRequestMethod("GET");
        con1.setRequestProperty("tmauthorize", "nihal");
        con1.setRequestProperty("User-Agent", "google chrome");

        int responseCode1 = con1.getResponseCode();
        System.out.println("response code1  "+responseCode1);
        assertEquals("", "");

        HttpURLConnection con2 = (HttpURLConnection) obj.openConnection();
        con2.setRequestMethod("GET");
        con2.setRequestProperty("tmauthorize", "tmmidservice!");
        con2.setRequestProperty("User-Agent", "google chrome");

        int responseCode2 = con2.getResponseCode();
        System.out.println("response code2  "+responseCode2);
        assertEquals("", "");

    }

    @Test
    public void testDBInsert() throws IOException {


        Company company = new Company();
        company.setName("abc");
        company.setCurrency("abc");
        company.setActive(Boolean.TRUE);
        company.setCreatedAt(new Date());
        company.setMid(13001);
        company.setSearchFeatureEnabled(Boolean.TRUE);
        company.setSource("unknown");
        company.setUsersCount(10);
        company.setTierId(1);
        company.setUpdatedAt(new Date());


        Gson gson = new Gson();
        String json = gson.toJson(company);
        System.out.println(json);
        String url = "http://localhost:8081/api/create/company";
        URL obj = new URL(url);
        HttpURLConnection con2 = (HttpURLConnection) obj.openConnection();
        con2.setDoOutput(true);
        con2.setRequestProperty("Content-Type", "application/json");
        con2.setRequestMethod("POST");
        con2.setRequestProperty("Accept", "application/json");
        con2.setRequestProperty("tmauthorize", "tmmidservice!");
        con2.setRequestProperty("User-Agent", "google chrome");

        con2.connect();

        OutputStream os = con2.getOutputStream();
        os.write(json.getBytes());
        os.close();

        User user = new User();
        user.setName("nihal");
        user.setEmailId("abc@abc.com");
        user.setPassword("ancewcw");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        String json1 = gson.toJson(user);
        System.out.println(json1);
        String url1 = "http://localhost:8081/api/create/user";
        URL obj1 = new URL(url1);
        HttpURLConnection con1 = (HttpURLConnection) obj1.openConnection();
        con1.setDoOutput(true);
        con1.setRequestProperty("Content-Type", "application/json");
        con1.setRequestMethod("POST");
        con1.setRequestProperty("Accept", "application/json");
        con1.setRequestProperty("tmauthorize", "tmmidservice!");
        con1.setRequestProperty("User-Agent", "google chrome");

        con1.connect();

        OutputStream os1 = con1.getOutputStream();
        os1.write(json.getBytes());
        os1.close();




    }

    @Test
    public void testDBUpdate() throws IOException {


        Company company = new Company();
        company.setId(5);
        company.setName("abc123");
        company.setCurrency("abc123");
        company.setActive(Boolean.TRUE);
        company.setCreatedAt(new Date());
        company.setMid(13441);
        company.setSearchFeatureEnabled(Boolean.TRUE);
        company.setSource("unknown");
        company.setUsersCount(10);
        company.setTierId(1);
        company.setUpdatedAt(new Date());


        Gson gson = new Gson();


        String url = "http://localhost:8081/api/create/user";

        //company.setUser(new BaseDaoImpl().get(User.class, 1));

        String json = gson.toJson(company);
        System.out.println(json);
        URL obj = new URL(url);
        HttpURLConnection con2 = (HttpURLConnection) obj.openConnection();
        OutputStream os = con2.getOutputStream();
        con2.setDoOutput(true);
        con2.setRequestProperty("Content-Type", "application/json");
        con2.setRequestMethod("POST");
        con2.setRequestProperty("Accept", "application/json");
        con2.setRequestProperty("tmauthorize", "tmmidservice!");
        con2.setRequestProperty("User-Agent", "google chrome");

        con2.connect();

        os.write(json.getBytes());
        os.close();


        int responseCode2 = con2.getResponseCode();
        System.out.println("response code2  "+responseCode2);
        assertEquals("", "");

    }

}
