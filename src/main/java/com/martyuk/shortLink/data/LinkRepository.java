package com.martyuk.shortLink.data;

import com.martyuk.shortLink.entity.Link;
import com.martyuk.shortLink.entity.RawLink;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, Long> {
    Link findByModificatedLink(String link);
    Link findByRawLink(RawLink rawlink);
}
