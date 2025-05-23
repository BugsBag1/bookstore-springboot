package com.example.bookstore.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
    @NotBlank(message = "Название книги не должен быть пустым")
    @Size(min = 2, max = 100, message = "Название книги должен быть от 2 до 100 символов")
    private String title;

    @NotBlank(message = "Имя автора не должен быть пустым")
    @Size(min = 2, max = 100, message = "Имя автора должен быть от 2 до 100 символов")
    private String authorName;

    private List<String> tagNames = new ArrayList<>();
}
