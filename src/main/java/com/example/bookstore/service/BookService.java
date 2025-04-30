package com.example.bookstore.service;

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
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
