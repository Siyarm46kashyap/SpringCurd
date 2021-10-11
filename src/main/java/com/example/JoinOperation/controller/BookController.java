package com.example.JoinOperation.controller;

import com.example.JoinOperation.entity.Book;
import com.example.JoinOperation.repository.BookRepository;
import com.example.JoinOperation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @GetMapping("/book")    //Return all books detail
    public List<Book> getAllBook(){
        return this.bookService.getAll();
    }
    @PostMapping("/book")   // Save book details
    public Book createBook(@RequestBody Book book){
        return this.bookService.createBook(book);
    }

    @PutMapping("/book/{id}")   //Update indexed book details
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable Integer id) {
        try {
            Book existProduct = bookService.get(id);
            bookRepository.save(book);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{id}")    //Delete indexed book
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }

}
