package eu.fakje.api.entity;

import eu.fakje.api.helper.Hash;

public class Link
{
    private Long id;
    private String url, slug, hash;
    private int clicks;


    public Link(Long id, String url, String slug, int clicks)
    {
        this.id = id;
        this.url = url;
        this.slug = slug;
        this.clicks = clicks;
    }

    @Override
    public String toString()
    {
        return String.format("Link[id=%d]", this.id);
    }

    public Long getId()
    {
        return this.id;
    }
    public String getUrl()
    {
        return this.url;
    }

    public String getSlug()
    {
        return this.slug;
    }

    public String getHash()
    {
        return Hash.md5(getUrl());
    }

    public int getClicks()
    {
        return this.clicks;
    }
}