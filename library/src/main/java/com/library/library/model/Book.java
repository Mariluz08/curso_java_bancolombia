package com.library.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Book {

    private String bookId;
    private String titulo;
    private String descripcion;
    private String autor;
    private double precio;
    private int qty;

    public Book(String bookId, String titulo, String descripcion, String autor, double precio, int qty) {
        this.bookId = bookId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.precio = precio;
        this.qty = qty;
    }

}
