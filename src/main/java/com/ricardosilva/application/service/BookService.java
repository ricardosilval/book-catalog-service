package com.ricardosilva.application.service;

import com.ricardosilva.domain.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    Book create(Book book);

    Optional<Book> findById(UUID id);

    List<Book> findAll();
}