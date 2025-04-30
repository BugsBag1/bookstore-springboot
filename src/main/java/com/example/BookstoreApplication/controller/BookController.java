package com.example.BookstoreApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books/hello")
public class BookController {
    @GetMapping
    public String sayHello() {
        return "Добро пожаловать в книжный магазин!";
    }
}
