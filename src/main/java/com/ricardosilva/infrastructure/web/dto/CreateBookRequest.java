package com.ricardosilva.infrastructure.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateBookRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String isbn;

    @NotNull
    private LocalDate publishedDate;

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
}