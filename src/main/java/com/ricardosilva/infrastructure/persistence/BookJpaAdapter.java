package com.ricardosilva.infrastructure.persistence;

import com.ricardosilva.application.port.out.BookRepositoryPort;
import com.ricardosilva.domain.model.Book;
import com.ricardosilva.domain.model.BookStatus;
import com.ricardosilva.infrastructure.persistence.entity.BookJpaEntity;
import com.ricardosilva.infrastructure.persistence.repository.SpringDataBookRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class BookJpaAdapter implements BookRepositoryPort {

    private final SpringDataBookRepository repository;

    public BookJpaAdapter(SpringDataBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {

        BookJpaEntity entity = new BookJpaEntity(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublishedDate(),
                book.getStatus()
        );

        BookJpaEntity saved = repository.save(entity);

        return new Book(
                saved.getId(),
                saved.getTitle(),
                saved.getAuthor(),
                saved.getPublishedDate(),
                saved.getIsbn(),
                BookStatus.AVAILABLE
        );
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return repository.findById(id)
                .map(entity -> new Book(
                        entity.getId(),
                        entity.getTitle(),
                        entity.getAuthor(),
                        entity.getPublishedDate(),
                        entity.getIsbn(),
                        null


                ));
    }
}