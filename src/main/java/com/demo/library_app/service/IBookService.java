package com.demo.library_app.service;

import com.demo.library_app.dto.BookInsertDTO;
import com.demo.library_app.dto.BookReadOnlyDTO;
import com.demo.library_app.model.Book;
import org.springframework.data.domain.Page;

public interface IBookService {
    Book saveBook(BookInsertDTO dto);
    Page<BookReadOnlyDTO> getPaginatedBooks(int page, int size);
}
