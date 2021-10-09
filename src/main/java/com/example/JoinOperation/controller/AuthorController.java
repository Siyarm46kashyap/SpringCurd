package com.example.JoinOperation.controller;

import com.example.JoinOperation.entity.Author;
import com.example.JoinOperation.repository.AuthorRepository;
import com.example.JoinOperation.repository.BookRepository;
import com.example.JoinOperation.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;



    @GetMapping("/author")
    public List<Author> getAllAuthors(){
        return this.authorService.getAll();
    }

    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author){
        return this.authorService.createAuthor(author);
    }


}
