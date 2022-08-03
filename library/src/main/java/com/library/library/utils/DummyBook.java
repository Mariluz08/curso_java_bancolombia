package com.library.library.utils;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.library.library.model.Book;
import com.library.library.service.BookService;

@Component
public class DummyBook {
    private BookService bookService;

    public DummyBook(BookService bookService) {
        this.bookService = bookService;
    }

    @PostConstruct
    public void init() {
        bookService.addBook(new Book(null, "libro1", "desc1", "Mari", 3000, 1));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        bookService.addBook(new Book(null, "libro2", "desc1", "Mari", 3000, 3));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        bookService.addBook(new Book(null, "libro3", "desc1", "Mari", 3000, 9));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        bookService.addBook(new Book(null, "libro4", "desc1", "Mari", 3000, 4));
    }
}
