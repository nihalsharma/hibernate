package com.tm.mid.client.json;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigP on 9/22/14.
 */
public class CustomJsonStringToListDeserializer extends JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String json = jsonParser.getText();
        List<String> strings = new ArrayList<>();
        if (json.contains(":")) {
            String[] tokens = json.split(":");
            for (String s : tokens) {
                strings.add(s);
            }
        }
        return strings;
    }
}
