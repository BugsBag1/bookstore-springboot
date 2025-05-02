package com.example.bookstore.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private String authorName;
    private List<String> tagNames = new ArrayList<>();
}
