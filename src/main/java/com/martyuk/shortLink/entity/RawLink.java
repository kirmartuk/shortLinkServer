package com.martyuk.shortLink.entity;

import javax.persistence.*;

@Entity
public class RawLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String rawLink;

    public RawLink(String rawLink) {
        this.rawLink = rawLink;
    }

    public RawLink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRawLink() {
        return rawLink;
    }

    public void setRawLink(String rawLink) {
        this.rawLink = rawLink;
    }
}
