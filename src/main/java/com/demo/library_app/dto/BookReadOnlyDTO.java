package com.demo.library_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookReadOnlyDTO {

    private Long id;

    private String title;

    private String author;

    private String isbn;

    private String genre;

    private int publishedYear;

    private boolean available;
}
