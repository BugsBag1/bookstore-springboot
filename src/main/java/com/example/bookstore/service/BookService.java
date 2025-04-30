package com.example.bookstore.service;

import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    final static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1L, "Java", "Java"));
        books.add(new Book(2L, "SQL", "SQL"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElseThrow(() -> new BookNotFoundException(id));
    }
}
