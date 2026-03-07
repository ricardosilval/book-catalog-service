package com.ricardosilva.application.service;

import com.ricardosilva.domain.model.Book;
import com.ricardosilva.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}