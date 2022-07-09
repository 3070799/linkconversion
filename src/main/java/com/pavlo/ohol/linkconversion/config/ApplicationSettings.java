package com.pavlo.ohol.linkconversion.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Pavel Ohol
 */
@Component
@ConfigurationProperties(prefix = "linkconversion", ignoreUnknownFields = false)
@Getter
public final class ApplicationSettings {

    private final LinkSettings linkSettings = new LinkSettings();


    @Getter
    @Setter
    public static class LinkSettings {

        private String serverUrl;
        private Integer linkLength;
    }

}
