package com.example.bookstore.mapper;

import com.example.bookstore.DTO.BookRequestDTO;
import com.example.bookstore.DTO.BookResponseDTO;
import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookMapper {
    public static Book toEntity(BookRequestDTO reqDTO, Author author, Set<Tag> tagList) {
        Book book = new Book();
        book.setTitle(reqDTO.getTitle());
        book.setAuthor(author);
        for (Tag tag : tagList) {
            book.getTags().add(tag);
        }
        return book;
    }

    public static BookResponseDTO toDTO(Book entity) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setTitle(entity.getTitle());
        dto.setId(entity.getId());
        dto.setAuthorName(entity.getAuthor().getName());
        List<String> tagNames = new ArrayList<>();
        for (Tag tag : entity.getTags()) {
            tagNames.add(tag.getName());
        }
        dto.setTagNames(tagNames);
        return dto;
    }
}
