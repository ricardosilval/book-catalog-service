package com.ricardosilva.application.port.out;

import com.ricardosilva.domain.model.Book;

import java.util.Optional;
import java.util.UUID;

public interface BookRepositoryPort {

    Book save(Book book);

    Optional<Book> findById(UUID id);
}