package com.example.bookstore.controller;

import com.example.bookstore.DTO.BookRequestDTO;
import com.example.bookstore.DTO.BookResponseDTO;
import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Добро пожаловать в книжный магазин!";
    }

    @GetMapping
    public List<BookResponseDTO> getBooks() {
        return  bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponseDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody BookRequestDTO requestDTO) {
        System.out.println("CREATE NEW BOOK" + requestDTO);
        BookResponseDTO newBook = bookService.createBook(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDTO requestDTO) {
        System.out.println("UPDATE NEW BOOK" + requestDTO);
        BookResponseDTO updateBook = bookService.updateBook(id, requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        System.out.println("DELETE NEW BOOK" + id);
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
