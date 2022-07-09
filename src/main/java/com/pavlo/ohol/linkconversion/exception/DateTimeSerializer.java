package com.pavlo.ohol.linkconversion.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * @author Pavel Ohol
 */

public final class DateTimeSerializer extends JsonSerializer<OffsetDateTime> {

    @Override
    public void serialize(final OffsetDateTime value,
                          final JsonGenerator gen,
                          final SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString());
    }
}
