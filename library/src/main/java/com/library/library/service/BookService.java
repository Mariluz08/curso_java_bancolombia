package com.library.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.library.model.Book;
import com.library.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Book get(String bookId) {
        return bookRepository.getBook(bookId);
    }

    public List<Book> findByAuthor(String autorId) {
        return bookRepository.findByAuthor(autorId);
    }
    public List<Book> findByTitle(String titulo) {
        return bookRepository.findByTitle(titulo);
    }

    public Book addBook(Book book) {
        book.setBookId(null);
        return bookRepository.save(book);
    }
    public Book updateBook(String bookId, Book book){
        Book bookR= bookRepository.getBook(bookId);
        if(bookR == null){
           return null; 
        }
        book.setBookId(bookId);
        return bookRepository.save(book);
    }

    public Book delete(String bookId){
        return bookRepository.delete(bookId);
    }
}
