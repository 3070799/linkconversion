package com.pavlo.ohol.linkconversion.repository;

import com.pavlo.ohol.linkconversion.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Pavel Ohol
 */

public interface LinkRepository extends JpaRepository<Link, String> {

    Optional<Link> findByShortURL(String url);
}
