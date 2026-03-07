package com.ricardosilva.infrastructure.persistence.entity;

import com.ricardosilva.domain.model.BookStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "books")
public class BookJpaEntity {

    @Id
    private UUID id;

    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus status;


    public BookJpaEntity() {
    }

    public BookJpaEntity(UUID id, String title, String author,
                         String isbn, LocalDate publishedDate, BookStatus status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.status = BookStatus.AVAILABLE;


    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public BookStatus getStatus() {
        return status;
    }
}