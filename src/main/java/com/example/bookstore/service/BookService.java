package com.example.bookstore.service;

import com.example.bookstore.DTO.BookRequestDTO;
import com.example.bookstore.DTO.BookResponseDTO;
import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public List<BookResponseDTO> getAllBooks() {
        List<BookResponseDTO> responseDTOList = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            responseDTOList.add(BookMapper.toDTO(book));
        }
        return responseDTOList;
    }

    public BookResponseDTO getBookById(long id) {
        return BookMapper.toDTO(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id)));
    }

    public BookResponseDTO createBook(BookRequestDTO requestDTO) {
        Author author = authorRepository.findByName(requestDTO.getAuthorName());
        if (author == null) {
            author = new Author();
            author.setName(requestDTO.getAuthorName());
            authorRepository.save(author);
        }
        Book book = BookMapper.toEntity(requestDTO, author);
        bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    public BookResponseDTO updateBook(Long currId,BookRequestDTO requestDTO) {
        Book book = bookRepository.findById(currId).orElseThrow(() -> new BookNotFoundException(currId));
        book.setTitle(requestDTO.getTitle());
        Author author = authorRepository.findByName(requestDTO.getAuthorName());
        if (author == null) {
            author = new Author();
            author.setName(requestDTO.getAuthorName());
            authorRepository.save(author);
        }
        book.setAuthor(author);
        bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }


}
