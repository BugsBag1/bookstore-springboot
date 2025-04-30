package com.example.bookstore.exception;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Книга с ID " + id + " не найдена.");
    }
}
