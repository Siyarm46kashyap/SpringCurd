package com.example.JoinOperation.service;

import com.example.JoinOperation.entity.Book;
import com.example.JoinOperation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;


    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return this.bookRepository.save(book);
    }

    public Book get(Integer id) {
        return bookRepository.findById(id).get();
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
