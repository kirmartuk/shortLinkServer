package com.martyuk.shortLink.data;

import com.martyuk.shortLink.entity.RawLink;
import org.springframework.data.repository.CrudRepository;

public interface RawLinkRepository extends CrudRepository<RawLink,Long> {
    RawLink findByRawLink(String rawLink);
}
