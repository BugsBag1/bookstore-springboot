package com.example.bookstore.service;

import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    final BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long currId,Book book) {
        Book NeedBook = getBookById(currId);
        if (NeedBook != null) {
            NeedBook.setTitle(book.getTitle());
            NeedBook.setAuthor(book.getAuthor());
            bookRepository.save(NeedBook);
        }
        return NeedBook;
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
