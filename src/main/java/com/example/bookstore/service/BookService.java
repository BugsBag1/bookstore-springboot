package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Java", "Java"));
        books.add(new Book(2L, "SQL", "SQL"));
        return books;
    }
}
