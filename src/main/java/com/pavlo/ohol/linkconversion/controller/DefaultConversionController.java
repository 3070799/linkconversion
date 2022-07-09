package com.pavlo.ohol.linkconversion.controller;

import com.pavlo.ohol.linkconversion.config.ApplicationSettings;
import com.pavlo.ohol.linkconversion.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Pavel Ohol
 */

@RestController
@AllArgsConstructor
public class DefaultConversionController implements ConversionController {

    private final ApplicationSettings applicationSettings;
    private final LinkService linkService;

    @Override
    @PostMapping(path = "/convert")
    public ResponseEntity<String> getShortLink(@RequestBody String link) {
        return ResponseEntity.ok(applicationSettings.getLinkSettings().getServerUrl() + linkService.create(link).getShortURL());
    }

    @GetMapping("/{link}")
    public RedirectView redirectWithUsingRedirectView(@PathVariable String link) {
        return new RedirectView(linkService.findByShortLink(link).getOriginalUrl());
    }
}
