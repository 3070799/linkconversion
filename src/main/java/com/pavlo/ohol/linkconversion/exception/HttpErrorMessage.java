package com.pavlo.ohol.linkconversion.exception;

import lombok.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

import static java.util.Objects.nonNull;

/**
 * @author Pavel Ohol
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
public class HttpErrorMessage extends ErrorMessage {

    private HttpStatus httpStatus;

    private Integer internalCode;

    private String requestId;

    private String requestDescription;

    private HttpMethod httpMethod;

    private String message;

    @Builder(builderMethodName = "httpErrorBuilder")
    public HttpErrorMessage(final ErrorDescription reason,
                            final ErrorSeverity severity,
                            final Object payload,
                            final String originError,
                            final OffsetDateTime timestamp,
                            final Throwable throwable,
                            final HttpStatus httpStatus,
                            final String requestId,
                            final String requestDescription,
                            final HttpMethod httpMethod) {
        super(reason, severity, payload, originError, throwable, timestamp);
        this.httpStatus = httpStatus;
        this.internalCode = reason.getCode();
        this.requestId = requestId;
        this.requestDescription = requestDescription;
        this.httpMethod = httpMethod;
        this.message = reason.getMessage();
    }

    public static HttpErrorMessage fromErrorMessage(
            final ErrorMessage errorMessage) {
        return HttpErrorMessage.httpErrorBuilder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .reason(nonNull(errorMessage.getReason()) ? errorMessage.getReason() : null)
                .severity(nonNull(errorMessage.getSeverity()) ? errorMessage.getSeverity() : null)
                .payload(nonNull(errorMessage.getPayload()) ? errorMessage.getReason() : null)
                .originError(nonNull(errorMessage.getOriginError()) ? errorMessage.getOriginError() : null)
                .throwable(nonNull(errorMessage.getOriginException()) ? errorMessage.getOriginException() : null)
                .timestamp(nonNull(errorMessage.getTimestamp()) ? errorMessage.getTimestamp() : null)
                .build();
    }
}
