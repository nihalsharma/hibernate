package com.tm.mid.client.json;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nihal on 9/18/14.
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<DateTime> {
    protected static final DateTimeFormatter FULL_DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();
        return FULL_DATE_FORMAT.parseDateTime(date);
    }
}
