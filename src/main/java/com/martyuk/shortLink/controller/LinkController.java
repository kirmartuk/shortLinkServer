package com.martyuk.shortLink.controller;

import com.martyuk.shortLink.controller.dto.LinkItemDTO;
import com.martyuk.shortLink.data.LinkRepository;
import com.martyuk.shortLink.entity.Link;
import com.martyuk.shortLink.service.LinkService;
import com.martyuk.shortLink.service.ValidCheckService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin(origins = "*")
public class LinkController {

    private final LinkService linkService;
    private final LinkRepository linkRepository;
    private final ValidCheckService validCheckService;
    // TODO change path
    private final static String URL_PATH = "https://qclik.herokuapp.com/go";

    public LinkController(LinkService linkService, LinkRepository linkRepository, ValidCheckService validCheckService) {
        this.linkService = linkService;
        this.linkRepository = linkRepository;
        this.validCheckService = validCheckService;
    }

    @GetMapping("go/{id}")
    public RedirectView get(@PathVariable String id) {

        Link link;
        link = linkRepository.findByModificatedLink(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(link.getRawLink().getRawLink());

        return redirectView;
    }

        @PostMapping("/create")
        public String create(@RequestBody LinkItemDTO dto) {
        if(!validCheckService.isValid(dto.getRawLink())){
            return "Некорректная ссылка";
        }
            return URL_PATH +linkService.create(dto.getRawLink()).getModificatedLink();
    }

}
