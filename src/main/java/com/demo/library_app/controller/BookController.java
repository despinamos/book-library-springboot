package com.demo.library_app.controller;

import com.demo.library_app.dto.BookInsertDTO;
import com.demo.library_app.dto.BookPatchDTO;
import com.demo.library_app.dto.BookReadOnlyDTO;
import com.demo.library_app.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<BookReadOnlyDTO> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/api/books/{id}")
    public BookReadOnlyDTO getBookById(@PathVariable Long id) {
        return bookService.getBookByID(id);
    }

    @PostMapping("/api/books")
    public BookReadOnlyDTO createBook(@Valid @RequestBody BookInsertDTO dto) {
        return bookService.createBook(dto);
    }

    @PatchMapping("/api/books/{id}")
    public BookReadOnlyDTO patchBookById(@PathVariable Long id, @RequestBody BookPatchDTO dto) {
        return bookService.patchBookById(id, dto);
    }

    @DeleteMapping("api/books/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

}
