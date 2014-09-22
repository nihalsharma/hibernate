package com.tm.mid.client.utils;

import com.tm.mid.client.exception.TMMIDConversionException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nihal on 9/19/14.
 */
public class JSONUtil {

    public <T> List<T> getListFromJson(Class<T> c, String json) throws TMMIDConversionException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<T> myObjects = mapper.readValue(json, new TypeReference<List<T>>() {
            });
            return myObjects;
        } catch (Exception e) {
            throw new TMMIDConversionException(e.getMessage(), e.getCause());
        }
    }

    public <T1, T2> HashMap<T1, T2> getMapFromJson(String json) throws TMMIDConversionException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<T1, T2> map = mapper.readValue(json, new TypeReference<HashMap<T1, T2>>() {
            });
            return map;
        } catch (Exception e) {
            throw new TMMIDConversionException(e.getMessage(), e.getCause());
        }
    }

    public <T> T getObjectFromJson(Class<T> c, String json) throws TMMIDConversionException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            T object = mapper.readValue(json, c);
            return object;
        } catch (JsonGenerationException e) {
            throw new TMMIDConversionException(e.getMessage(), e.getCause());
        } catch (JsonMappingException e) {
            throw new TMMIDConversionException(e.getMessage(), e.getCause());
        } catch (IOException e) {
            throw new TMMIDConversionException(e.getMessage(), e.getCause());
        }
    }

}
