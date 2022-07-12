package com.pavlo.ohol.linkconversion.controller;

import com.pavlo.ohol.linkconversion.DTO.LinkRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Pavel Ohol
 */

public interface ConversionController {

    ResponseEntity<String> getShortLink(LinkRequest linkRequest);

    RedirectView redirectWithUsingRedirectView(String link);
}
