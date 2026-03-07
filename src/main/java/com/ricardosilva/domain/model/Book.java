package com.ricardosilva.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private String isbn;
    private BookStatus status;

    public Book(UUID id, String title, String author, LocalDate publishedDate, String isbn, BookStatus status) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Debe indicar título del libro");
        }

        if (author == null) {
            throw new IllegalArgumentException("Debe indicar autor");
        }

        this.id = id == null ? UUID.randomUUID() : id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.status = status == null ? BookStatus.AVAILABLE : status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
