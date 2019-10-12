package com.martyuk.shortLink.data;

import com.martyuk.shortLink.entity.Link;
import com.martyuk.shortLink.entity.RawLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findByModificatedLink(String link);
    Link findByRawLink(RawLink rawlink);
}
