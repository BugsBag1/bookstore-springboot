package com.example.bookstore.service;

import com.example.bookstore.DTO.BookRequestDTO;
import com.example.bookstore.DTO.BookResponseDTO;
import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Tag;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final TagRepository tagRepository;


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

        List<String> tagNames = requestDTO.getTagNames();
        Set<Tag> tags = new HashSet<>();
        for (String tagName : tagNames) {
            Tag tag = tagRepository.findByName(tagName);
            if (tag == null) {
                tag = new Tag();
                tag.setName(tagName);
            }
            tagRepository.save(tag);
            tags.add(tag);
        }

        Book book = BookMapper.toEntity(requestDTO, author, tags);
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
        List<String> tagNames = requestDTO.getTagNames();
        Set<Tag> tags = new HashSet<>();
        for (String tagName : tagNames) {
            Tag tag = tagRepository.findByName(tagName);
            if (tag == null) {
                tag = new Tag();
                tag.setName(tagName);
            }
            tags.add(tag);
        }
        book.setAuthor(author);
        book.setTags(tags);
        bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }


}
