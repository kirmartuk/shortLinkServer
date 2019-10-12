package com.martyuk.shortLink.entity;

import javax.persistence.*;

@Entity
@Table(name = "rawlink")
public class RawLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "raw")
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
