package com.tavv.springbootapi.Common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class JsonDateDeSerializer extends JsonDeserializer<Date> {

    // use joda library for thread safe issue
    private static final DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd/MM/yyyy hh:mm:ss");

    @Override
    public Date deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (jp.getCurrentToken().equals(JsonToken.VALUE_STRING))
            return dateFormat.parseDateTime(jp.getText().toString()).toDate();
        return null;
    }

}