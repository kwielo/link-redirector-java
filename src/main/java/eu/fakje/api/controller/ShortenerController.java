package eu.fakje.api.controller;


import eu.fakje.api.entity.Link;
import eu.fakje.api.exception.ConnectionToDatabaseFailedException;
import eu.fakje.api.helper.Token;
import eu.fakje.api.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@RestController
public class ShortenerController 
{

    @RequestMapping(value = "/cut",
        params = {"url"}
    )
    @ResponseBody
    public Link shortenTheURL(
            @RequestParam(value = "url") String url
    ) throws SQLException, ConnectionToDatabaseFailedException
    {
        LinkRepository repo = new LinkRepository();
        Link newLink = new Link(null, url, Token.getToken(), 0);
        Link existingLink = repo.findByHash(newLink.getHash());
        if (existingLink != null) {
            return existingLink;
        }
        return repo.saveLink(newLink);
    }

    @RequestMapping(
            value = "/{slug}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public void redirect(
            @PathVariable("slug") String slug,
            HttpServletResponse httpServletResponse
    ) throws SQLException, IOException
    {
        LinkRepository linkRepository = new LinkRepository();
        Link link = linkRepository.findBySlug(slug);

        httpServletResponse.sendRedirect(link.getUrl());
    }
}