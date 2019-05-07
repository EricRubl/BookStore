package com.sdi.bookstore.model.Book;

import com.sdi.bookstore.model.BaseConverter;
import org.springframework.stereotype.Component;

@Component
public class BookConverter extends BaseConverter<Book, BookDTO> {
    @Override
    public Book DTOToModel(BookDTO dto) {
        Book book = Book.builder()
                .title(dto.getTitle())
                .build();
        book.setId(dto.getId());
        return book;
    }

    @Override
    public BookDTO ModelToDTo(Book book) {
        BookDTO dto = BookDTO.builder()
                .title(book.getTitle())
                .build();
        dto.setId(book.getId());
        return dto;
    }
}