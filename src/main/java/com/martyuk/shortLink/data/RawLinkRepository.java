package com.martyuk.shortLink.data;

import com.martyuk.shortLink.entity.RawLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RawLinkRepository extends CrudRepository<RawLink,Long> {
    RawLink findByRawLink(String rawLink);
}
