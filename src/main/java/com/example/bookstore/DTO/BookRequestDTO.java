package com.example.bookstore.DTO;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
    @NotNull(message = "Название книги не должен быть пустым")
    @Size(min = 2, max = 100, message = "Название книги должен быть от 2 до 100 символов")
    private String title;

    @NotNull(message = "Имя автора не должен быть пустым")
    @Size(min = 2, max = 100, message = "Имя автора должен быть от 2 до 100 символов")
    private String author;
}
