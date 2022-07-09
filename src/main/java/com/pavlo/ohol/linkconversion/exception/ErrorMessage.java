package com.pavlo.ohol.linkconversion.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.time.OffsetDateTime;

/**
 * @author Pavel Ohol
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ErrorMessage {

    private ErrorDescription reason;

    @Builder.Default
    private ErrorSeverity severity = ErrorSeverity.ERROR;

    private Object payload;

    private String originError;

    private Throwable originException;

    @Builder.Default
    @JsonSerialize(using = DateTimeSerializer.class)
    private OffsetDateTime timestamp = OffsetDateTime.now();
}
