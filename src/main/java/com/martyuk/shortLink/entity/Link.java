package com.martyuk.shortLink.entity;

import javax.persistence.*;
@Entity
@Table(name = "link")
public class Link  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "mod")
    private String modificatedLink;
    @JoinColumn(name = "rawLink_id")
    @OneToOne
    private RawLink rawLink;

    public Link() {
    }

    public Link(String modificateLink, RawLink rawLink) {
        this.modificatedLink = modificateLink;
        this.rawLink = rawLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModificatedLink() {
        return modificatedLink;
    }

    public void setModificatedLink(String modificatedLink) {
        this.modificatedLink = modificatedLink;
    }

    public RawLink getRawLink() {
        return rawLink;
    }

    public void setRawLink(RawLink rawLink) {
        this.rawLink = rawLink;
    }
}
