package com.martyuk.shortLink.service;

import com.martyuk.shortLink.entity.Link;
import com.martyuk.shortLink.entity.RawLink;

public interface LinkService {
    Link create(String rawLink);
}
