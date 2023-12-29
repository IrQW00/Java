package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData(){

        List<Book> books = jdbcTemplate.query("SELECT b.ID, a.FIRST_NAME, a.LAST_NAME, b.TITLE, b.PRICE_OLD, b.PRICE " +
                "FROM BOOKS as b LEFT JOIN AUTHORS as a " +
                "WHERE a.ID = b.AUTHOR_ID ", (ResultSet rs, int rownum)->{
            Book book = new Book();
            book.setId(rs.getInt("ID"));
            book.setAuthor(rs.getString("FIRST_NAME") + rs.getString("LAST_NAME"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("PRICE_OLD"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }
}
