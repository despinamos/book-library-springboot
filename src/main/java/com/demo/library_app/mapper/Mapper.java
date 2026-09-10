package com.demo.library_app.mapper;

import com.demo.library_app.dto.BookInsertDTO;
import com.demo.library_app.dto.BookReadOnlyDTO;
import com.demo.library_app.model.Book;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Book mapToBookEntity(BookInsertDTO bookInsertDTO) {
        Book book = new Book();
        book.setTitle(bookInsertDTO.getTitle());
        book.setAuthor(bookInsertDTO.getAuthor());
        book.setIsbn(bookInsertDTO.getIsbn());
        book.setGenre(bookInsertDTO.getGenre());
        book.setPublishedYear(bookInsertDTO.getPublishedYear());
        book.setAvailable(bookInsertDTO.getAvailable());
        return book;
    }

    public BookReadOnlyDTO mapToBookReadOnlyDTO(Book book) {
        return new BookReadOnlyDTO(book.getId(), book.getTitle(),
                book.getAuthor(), book.getIsbn(), book.getGenre(),
                book.getPublishedYear(), book.isAvailable());
    }
}
