package com.pavlo.ohol.linkconversion.service;

import com.pavlo.ohol.linkconversion.model.Link;

/**
 * @author Pavel Ohol
 */

public interface LinkService {

    Link findByShortLink(String link);

    Link create(String originalLink);
}
