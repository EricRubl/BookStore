package com.sdi.bookstore.model.Book;

import com.sdi.bookstore.model.BaseDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookConverter {
    public Book DTOToModel(BookDTO dto) {
        Book book = Book.builder()
                .title(dto.getTitle())
                .build();
        book.setId(dto.getId());
        return book;
    }

    public BookDTO ModelToDTo(Book book) {
        BookDTO dto = BookDTO.builder()
                .title(book.getTitle())
                .build();
        dto.setId(book.getId());
        return dto;
    }

    public Set<Integer> convertModelsToIDs (Set<Book> modelSet) {
        return modelSet.stream()
                .map(Book::getId)
                .collect(Collectors.toSet());
    }

    public Set<Integer> convertDTOsToIDs(Set<BookDTO> dtoSet) {
        return dtoSet.stream()
                .map(BaseDTO::getId)
                .collect(Collectors.toSet());
    }

    public Set<BookDTO> convertModelsToDtos(Collection<Book> models) {
        return models.stream()
                .map(this::ModelToDTo)
                .collect(Collectors.toSet());
    }
}