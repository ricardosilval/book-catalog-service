package com.ricardosilva.infrastructure.persistence;

import com.ricardosilva.domain.model.Book;
import com.ricardosilva.domain.repository.BookRepository;
import com.ricardosilva.infrastructure.persistence.entity.BookJpaEntity;
import com.ricardosilva.infrastructure.persistence.repository.SpringDataBookRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BookRepositoryAdapter implements BookRepository {
    private final SpringDataBookRepository springDataRepository;

    public BookRepositoryAdapter(SpringDataBookRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Book save(Book book) {

        BookJpaEntity entity = toEntity(book);

        BookJpaEntity saved = springDataRepository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return springDataRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return springDataRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    // ==========================
    // MAPPERS
    // ==========================
//UUID id, String title, String author,
//                         String isbn, LocalDate publishedDate
    private BookJpaEntity toEntity(Book book) {
        return new BookJpaEntity(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublishedDate(),
                book.getStatus()
        );
    }

    private Book toDomain(BookJpaEntity entity) {
        return new Book(
                entity.getId(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getPublishedDate(),
                entity.getIsbn(),
                null
        );
    }
}