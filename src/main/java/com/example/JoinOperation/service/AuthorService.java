package com.example.JoinOperation.service;

import com.example.JoinOperation.entity.Author;
import com.example.JoinOperation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAll() {
        return this.authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return this.authorRepository.save(author);
    }
}
