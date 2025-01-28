package com.urlized.shortener.repository;

import com.urlized.shortener.models.ClickEvent;
import com.urlized.shortener.models.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {
    List<ClickEvent> findByUrlMapping(UrlMapping urlMapping);
    List<ClickEvent> findByUrlMappingIn(List<UrlMapping> urlMappings);

}
