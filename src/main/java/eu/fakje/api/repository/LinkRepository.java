package eu.fakje.api.repository;

import eu.fakje.api.db.Database;
import eu.fakje.api.entity.Link;
import java.sql.*;

public class LinkRepository
{
    public Link findBySlug(String slug) throws SQLException
    {
        Connection connection = Database.getDBConnection();

        String sql = "SELECT * FROM link WHERE slug = ? LIMIT 1";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, slug);

        ResultSet rs = stmt.executeQuery();

        Link link = null;

        while (rs.next()) {
            link = new Link(
                    rs.getLong("id"),
                    rs.getString("url"),
                    rs.getString("slug"),
                    rs.getInt("clicks")
            );
        }
        rs.close();
        stmt.close();
        connection.close();

        return link;
    }

    public Link findByHash(String hash) throws SQLException
    {
        Connection connection = Database.getDBConnection();

        String sql = "SELECT * FROM link WHERE hash = ? LIMIT 1";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, hash);

        ResultSet rs = stmt.executeQuery();

        Link link = null;

        while (rs.next()) {
            link = new Link(
                    rs.getLong("id"),
                    rs.getString("url"),
                    rs.getString("slug"),
                    rs.getInt("clicks")
            );
        }
        rs.close();
        stmt.close();
        connection.close();

        return link;
    }

    public Link[] readLinks() throws SQLException
    {
        Connection connection = Database.getDBConnection();
        Statement stmt = connection.createStatement();

        String sql = "SELECT id, slug, url, clicks, hash FROM link";
        ResultSet rs = stmt.executeQuery(sql);
        int rowCount = 0;
        if (rs.last()) {
            rowCount = rs.getRow();
            rs.beforeFirst();
        }

        Link[] links = new Link[rowCount];
        int i = 0;
        while (rs.next()) {
            links[i] = new Link(
                    rs.getLong("id"),
                    rs.getString("url"),
                    rs.getString("slug"),
                    rs.getInt("clicks")
            );
            i++;
        }
        rs.close();
        stmt.close();
        connection.close();

        return links;
    }

    public Link saveLink(Link link) throws SQLException
    {
        Connection connection = Database.getDBConnection();

        String insertSql = "INSERT INTO link (slug, url, hash, clicks) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(insertSql);
        stmt.setString(1, link.getSlug());
        stmt.setString(2, link.getUrl());
        stmt.setString(3, link.getHash());
        stmt.setInt(4, link.getClicks());

        stmt.executeUpdate();
        stmt.close();
        connection.close();

        return findByHash(link.getHash());
    }
}