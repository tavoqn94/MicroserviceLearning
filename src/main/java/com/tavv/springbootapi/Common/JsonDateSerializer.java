package com.tavv.springbootapi.Common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class JsonDateSerializer extends JsonSerializer<Date> {

    // use joda library for thread safe issue
    private static final DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd/MM/yyyy hh:mm:ss");

    @Override
    public void serialize(final Date date, final JsonGenerator gen, final SerializerProvider provider) throws IOException, JsonProcessingException {

        final String formattedDate = dateFormat.print(date.getTime());

        gen.writeString(formattedDate);
    }
}
