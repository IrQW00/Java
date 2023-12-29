package org.example.app.services;

import org.apache.log4j.Logger;
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
    private final Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    public boolean removeByRegex(String regex){
        AtomicBoolean isRemoved = new AtomicBoolean(false);
        Pattern pattern = Pattern.compile(regex);
        for (Book book1 : bookRepo.retreiveAll()) {
            String[] fields = {book1.getAuthor(), book1.getSize().toString(), book1.getTitle()};
            isRemoved.set(Arrays.stream(fields)
                    .anyMatch(s -> Pattern.matches(regex, s)));
            if (isRemoved.get()) {
                removeBookById(book1.getId());
            }
        }
        return isRemoved.get();

    }

    public void defaultInit() {
        logger.info("default INIT in book service");
    }

    public void defaultDestroy() {
        logger.info("default DESTROY in book service");
    }
}
