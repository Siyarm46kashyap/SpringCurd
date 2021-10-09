package com.example.JoinOperation.repository;

import com.example.JoinOperation.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
