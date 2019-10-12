package com.martyuk.shortLink.controller.dto;

public class LinkItemDTO {
    String rawLink;




    public LinkItemDTO(String rawLink) {
        this.rawLink = rawLink;

    }

    public LinkItemDTO() {
    }

    public String getRawLink() {
        return rawLink;
    }

    public void setRawLink(String rawLink) {
        this.rawLink = rawLink;
    }
}
