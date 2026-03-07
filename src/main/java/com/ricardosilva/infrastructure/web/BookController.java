package com.ricardosilva.infrastructure.web;

import com.ricardosilva.application.service.BookService;
import com.ricardosilva.application.usecase.CreateBookUseCase;
import com.ricardosilva.domain.model.Book;
import com.ricardosilva.domain.model.BookStatus;
import com.ricardosilva.infrastructure.web.dto.BookResponse;
import com.ricardosilva.infrastructure.web.dto.CreateBookRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final BookService bookService;


    public BookController(CreateBookUseCase createBookUseCase, BookService bookService) {
        this.createBookUseCase = createBookUseCase;
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(
            @Valid @RequestBody CreateBookRequest request) {
        Book book = new Book(
                UUID.randomUUID(),
                request.getTitle(),
                request.getAuthor(),
                request.getPublishedDate(),
                request.getIsbn(),
                BookStatus.AVAILABLE

        );

        Book saved = createBookUseCase.execute(book);


        BookResponse response = new BookResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getAuthor(),
                saved.getIsbn(),
                saved.getPublishedDate(),
                saved.getStatus().name()
        );


        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {

        List<BookResponse> books = bookService.findAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(books);
    }

    private BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublishedDate(),
                book.getStatus().name()
        );
    }
}