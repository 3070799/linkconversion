package com.pavlo.ohol.linkconversion.service;

import com.pavlo.ohol.linkconversion.config.ApplicationSettings;
import com.pavlo.ohol.linkconversion.exception.ApplicationException;
import com.pavlo.ohol.linkconversion.exception.ErrorDescription;
import com.pavlo.ohol.linkconversion.exception.ErrorMessage;
import com.pavlo.ohol.linkconversion.model.Link;
import com.pavlo.ohol.linkconversion.repository.LinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * @author Pavel Ohol
 */

@Service
@AllArgsConstructor
public class DefaultLinkService implements LinkService{

    private final ApplicationSettings applicationSettings;
    private final LinkRepository linkRepository;

    @Override
    public Link findByShortLink(String link) {
        return linkRepository.findByShortURL(link).orElseThrow(
                () -> new ApplicationException(ErrorMessage.builder()
                        .reason(ErrorDescription.SHORT_LINK_NOT_FOUND)
                        .build())
        );
    }

    @Override
    public Link create(String originalLink) {
        return linkRepository.save(Link.builder()
                .originalUrl(originalLink)
                .shortURL(generateShortLink())
                .build());
    }

    private String generateShortLink(){
        String generatedLink = randomAlphabetic(applicationSettings.getLinkSettings().getLinkLength());
        if(linkRepository.findByShortURL(generatedLink).isPresent()){
            return generateShortLink();
        }
        return generatedLink;
    }
}
