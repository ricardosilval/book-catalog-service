package com.ricardosilva.infrastructure.web.dto;

import java.time.LocalDate;
import java.util.UUID;

public class BookResponse {

    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
    private String status;

    public BookResponse(UUID id,
                        String title,
                        String author,
                        String isbn,
                        LocalDate publishedDate,
                        String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}