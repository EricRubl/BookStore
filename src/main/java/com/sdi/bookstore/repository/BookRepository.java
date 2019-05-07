package com.sdi.bookstore.repository;

import com.sdi.bookstore.model.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {}
