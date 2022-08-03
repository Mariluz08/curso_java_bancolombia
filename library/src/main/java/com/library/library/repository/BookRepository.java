package com.library.library.repository;

import java.util.List;

import com.library.library.model.Book;

public interface BookRepository {
    public List<Book> getAll();

    public Book getBook(String bookId);

    public List<Book> findByAuthor(String autor);

    public List<Book> findByTitle(String titulo);

    public Book save(Book book);

    public Book delete(String bookId);
}
