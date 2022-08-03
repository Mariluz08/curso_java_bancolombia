package com.library.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.library.library.model.Book;

@Repository
public class MemoryBookRespository implements BookRepository {

    private Map<String, Book> bookMap;

    public MemoryBookRespository() {
        bookMap = new HashMap<>();
    }

    @Override
    public List<Book> getAll() {

        List<Book> books = new ArrayList<>();
        books.addAll(bookMap.values());
        return books;
    }

    @Override
    public Book getBook(String bookId) {

        return bookMap.get(bookId);

    }

    @Override
    public List<Book> findByAuthor(String autor) {

        return bookMap.values().stream()
                .filter(book -> book.getAutor().toLowerCase().indexOf(autor.toLowerCase()) >= 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String titulo) {

        return bookMap.values().stream()
                .filter(book -> book.getTitulo().toLowerCase().indexOf(titulo.toLowerCase()) >= 0)
                .collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {

        if (book.getBookId() == null) {
            book.setBookId(String.valueOf(System.currentTimeMillis()));
        }
        bookMap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public Book delete(String bookId) {

        return bookMap.remove(bookId);

    }

}
