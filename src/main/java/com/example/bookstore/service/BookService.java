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

    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(Long currId,Book book) {
        Book NeedBook = getBookById(currId);
        if (NeedBook != null) {
            NeedBook.setTitle(book.getTitle());
            NeedBook.setAuthor(book.getAuthor());
        }
        return NeedBook;
    }

    public void deleteBook(Long bookId) {
        Book book = getBookById(bookId);
        if (book != null) {
            books.remove(book);
        }
    }
}
