package com.example.bookstore.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private Long id;
    private String title;
    private String author;

}
