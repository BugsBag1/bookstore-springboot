package com.example.bookstore.service;

import com.example.bookstore.DTO.BookRequestDTO;
import com.example.bookstore.DTO.BookResponseDTO;
import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.Book;
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

    public Book createBook(BookRequestDTO requestDTO) {
        Book book = BookMapper.toEntity(requestDTO);
        bookRepository.save(book);
        return book;
    }

    public BookResponseDTO updateBook(Long currId,BookRequestDTO requestDTO) {
        BookResponseDTO bookToUpdate = getBookById(currId);
        bookRepository.save(BookMapper.toEntity(requestDTO));
        return bookToUpdate;
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
