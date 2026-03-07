package com.ricardosilva.infrastructure.persistence.repository;

import com.ricardosilva.infrastructure.persistence.entity.BookJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataBookRepository
        extends JpaRepository<BookJpaEntity, UUID> {
}