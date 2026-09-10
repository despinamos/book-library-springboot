package com.demo.library_app.service;

import com.demo.library_app.core.exception.EntityAlreadyExistsException;
import com.demo.library_app.core.exception.EntityNotFoundException;
import com.demo.library_app.dto.BookInsertDTO;
import com.demo.library_app.dto.BookPatchDTO;
import com.demo.library_app.dto.BookReadOnlyDTO;
import com.demo.library_app.mapper.Mapper;
import com.demo.library_app.model.Book;
import com.demo.library_app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final Mapper mapper;

    public List<BookReadOnlyDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(mapper::mapToBookReadOnlyDTO)
                .toList();
    }

    public BookReadOnlyDTO getBookByID(Long id) {
        Book book = bookRepository.getReferenceById(id);
        return mapper.mapToBookReadOnlyDTO(book);
    }

    public BookReadOnlyDTO createBook(BookInsertDTO dto) {

        if(bookRepository.findByIsbn(dto.getIsbn()).isPresent()) {
            throw new EntityAlreadyExistsException(
                    "BOOK_ALREADY_EXISTS",
                    "A book with ISBN " + dto.getIsbn() + " already exists."
            );
        }

        Book book = mapper.mapToBookEntity(dto);

        Book savedBook = bookRepository.save(book);

        return mapper.mapToBookReadOnlyDTO(savedBook);
    }

    public BookReadOnlyDTO patchBookById(Long id, BookPatchDTO dto){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BOOK_NOT_FOUND", "Book with isbn" + dto.getIsbn() + "not found"));

        if (dto.getTitle() != null) {
            book.setTitle(dto.getTitle());
        }

        if (dto.getAuthor() != null) {
            book.setAuthor(dto.getAuthor());
        }

        if (dto.getIsbn() != null) {
            book.setIsbn(dto.getIsbn());
        }

        if (dto.getGenre() != null) {
            book.setGenre(dto.getGenre());
        }

        if (dto.getPublishedYear() != null) {
            book.setPublishedYear(dto.getPublishedYear());
        }

        if (dto.getAvailable() != null) {
            book.setAvailable(dto.getAvailable());
        }

        Book updatedBook = bookRepository.save(book);

        return mapper.mapToBookReadOnlyDTO(updatedBook);
    }

    public void deleteBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BOOK_NOT_FOUND", "Book was not found"));
        bookRepository.deleteById(id);

    }
}
