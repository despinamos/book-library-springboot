package com.demo.library_app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookInsertDTO {

    @NotNull(message = "Title cannot be null")
    @Size(min = 2, message = "Title must contain at least 2 characters.")
    private String title;

    @Size(min = 2, message = "Author name must contain at least 2 characters.")
    @NotNull(message = "Author name cannot be null")
    private String author;

    private String isbn;

    private String genre;

    private Integer publishedYear;

    private Boolean available;
}
