package com.pavlo.ohol.linkconversion.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Pavel Ohol
 */

@Getter
@Setter
@Builder
public class ApplicationException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public ApplicationException(final ErrorMessage anErrorMessage) {
        super(anErrorMessage.getReason().getMessage());
        errorMessage = anErrorMessage;
    }

    @Override
    public String toString() {
        return errorMessage.toString();
    }
}
