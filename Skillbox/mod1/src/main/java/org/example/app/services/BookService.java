package org.example.app.services;

import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        if(!isValidBook(book))
            return;
        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    private boolean isValidBook(Book book){
        return !("".equals(book.getTitle()) && "".equals(book.getAuthor()) && book.getSize() == null);
    }

    public boolean removeByRegex(String regex){
        AtomicBoolean isRemoved = new AtomicBoolean(false);
        bookRepo.retreiveAll().stream()
                .filter(book -> {
                    String[] fields = {book.getAuthor(), book.getSize().toString(), book.getTitle()};
                    return Arrays.stream(fields)
                            .anyMatch(s -> Pattern.matches(regex, s));
                }).forEach(book -> removeBookById(book.getId()));
        return isRemoved.get();
    }
}
