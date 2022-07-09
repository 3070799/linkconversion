package com.pavlo.ohol.linkconversion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Pavel Ohol
 */

public interface ConversionController {

    ResponseEntity<String> getShortLink (String originalLink);

    RedirectView redirectWithUsingRedirectView(String link);
}
