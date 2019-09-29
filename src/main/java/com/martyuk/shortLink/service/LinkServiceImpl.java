package com.martyuk.shortLink.service;

import com.martyuk.shortLink.data.LinkRepository;
import com.martyuk.shortLink.data.RawLinkRepository;
import com.martyuk.shortLink.entity.Link;
import com.martyuk.shortLink.entity.RawLink;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;
    private final RawLinkRepository rawLinkRepository;
    private final String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public LinkServiceImpl(LinkRepository linkRepository, RawLinkRepository rawLinkRepository) {
        this.linkRepository = linkRepository;
        this.rawLinkRepository = rawLinkRepository;
    }
    private String idToTinyUrl(long id) {
        StringBuilder tinyUrl = new StringBuilder();
        while(id>0)
        {
            tinyUrl.append(map.charAt(Math.toIntExact(id % 62)));
            id /= 62;
        }
        return tinyUrl.reverse().toString();
    }

    private long tinyUrlToId(String tinyUrl) {
        long id = 0;
        for(int i=0;i<tinyUrl.length();i++)
        {
            id = (id*62) + map.indexOf(tinyUrl.charAt(i));
        }
        return id;
    }

    @Override
    public Link create(String link) {
        RawLink existRawLink = rawLinkRepository.findByRawLink(link);
        if(existRawLink!=null){
            Link modLink = linkRepository.findByRawLink(existRawLink);
            return new Link(modLink.getModificatedLink(),existRawLink);
        }
        RawLink rawLink = new RawLink();
        rawLink.setRawLink(link);


        rawLinkRepository.save(rawLink);
        String modLink = idToTinyUrl(rawLink.getId());
        return linkRepository.save(new Link(modLink,rawLink));
    }
}
