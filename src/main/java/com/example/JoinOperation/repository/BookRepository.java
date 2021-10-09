package com.example.JoinOperation.repository;

import com.example.JoinOperation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
