package com.martyuk.shortLink.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URL;
@Service
@Transactional
public class ValidCheckServiceImpl implements ValidCheckService {
    @Override
    public boolean isValid(String url) {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }
}
