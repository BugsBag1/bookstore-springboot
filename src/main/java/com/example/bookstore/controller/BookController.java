package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Добро пожаловать в книжный магазин!";
    }

    @GetMapping
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Java", "Java"));
        books.add(new Book(2L, "SQL", "SQL"));
        return books;
    }
}
