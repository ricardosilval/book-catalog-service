package com.ricardosilva.application.usecase;

import com.ricardosilva.domain.model.Book;

public interface CreateBookUseCase {

    Book execute(Book book);
}