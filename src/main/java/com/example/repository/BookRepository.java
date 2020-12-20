package com.example.repository;

import com.example.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b JOIN b.author a "
            + "WHERE lower(b.name) LIKE CONCAT('%', lower(?1), '%') "
            + "OR lower(b.isbn) LIKE CONCAT('%', lower(?1), '%') "
            + "OR lower(b.serName) LIKE CONCAT('%', lower(?1), '%')"
            + "OR lower(a.name) LIKE CONCAT('%', lower(?1), '%')")
    public List<Book> findAll(@Param("keyword")String keyword);
}

