package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorsData(){

        List<Author> authors = jdbcTemplate.query("SELECT * FROM AUTHORS", (ResultSet rs, int rownum)->{
            Author author = new Author();
            author.setId(rs.getInt("ID"));
            author.setFirstName(rs.getString("FIRST_NAME"));
            author.setLastName(rs.getString("LAST_NAME"));
            return author;
        });
        return new ArrayList<>(authors);
    }
}
