package com.pavlo.ohol.linkconversion.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Pavel Ohol
 */

@AllArgsConstructor
@Getter
public enum ErrorDescription {

    SHORT_LINK_NOT_FOUND(1, "Short link not found")

    ;

    private final Integer code;

    private final String message;

}
