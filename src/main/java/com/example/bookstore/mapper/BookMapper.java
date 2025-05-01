package com.example.bookstore.mapper;

import com.example.bookstore.DTO.BookRequestDTO;
import com.example.bookstore.DTO.BookResponseDTO;
import com.example.bookstore.model.Book;

public class BookMapper {
    public static Book toEntity(BookRequestDTO reqDTO) {
        Book book = new Book();
        book.setTitle(reqDTO.getTitle());
        book.setAuthor(reqDTO.getAuthor());
        return book;
    }

    public static BookResponseDTO toDTO(Book entity) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setTitle(entity.getTitle());
        dto.setId(entity.getId());
        return dto;
    }
}
