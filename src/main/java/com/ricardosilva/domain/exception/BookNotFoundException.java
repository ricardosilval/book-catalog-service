package com.ricardosilva.domain.exception;


import java.util.UUID;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(UUID id) {
        super("Libro no encontrado con id: " + id);
    }
}