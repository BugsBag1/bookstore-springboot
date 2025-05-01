package com.example.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Название книги не должен быть пустым")
    @Size(min = 2, max = 100, message = "Название книги должен быть от 2 до 100 символов")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
