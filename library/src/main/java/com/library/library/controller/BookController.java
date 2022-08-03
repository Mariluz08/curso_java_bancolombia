package com.library.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.model.Book;
import com.library.library.service.BookService;

@RestController
@RequestMapping({ "book" })
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getAll(@RequestParam(required = false) String autor,
            @RequestParam(required = false) String titulo) {
        if (autor == null && titulo == null) {
            return this.bookService.getAll();
        } else if (autor != null) {
            return this.bookService.findByAuthor(autor);
        } else {
            return this.bookService.findByTitle(titulo);
        }
    }

    @GetMapping("/{bookId}")
    public Book get(@PathVariable String bookId) {
        return this.bookService.get(bookId);
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book) {
        return this.bookService.addBook(book);

    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable String bookId, @RequestBody Book book) {
        Book ret = this.bookService.updateBook(bookId, book);
        return ret;
    }

    @DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable String bookId) {
        return this.bookService.delete(bookId);
    }
}
