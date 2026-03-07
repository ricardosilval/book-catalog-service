package com.ricardosilva.application.service;

import com.ricardosilva.application.port.out.BookRepositoryPort;
import com.ricardosilva.application.usecase.CreateBookUseCase;
import com.ricardosilva.domain.model.Book;
import org.springframework.stereotype.Service;

@Service
public class CreateBookService implements CreateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public CreateBookService(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Book execute(Book book) {
        return bookRepositoryPort.save(book);
    }
}