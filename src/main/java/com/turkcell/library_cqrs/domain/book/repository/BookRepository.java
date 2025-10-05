package com.turkcell.library_cqrs.domain.book.repository;

import com.turkcell.library_cqrs.domain.book.model.Book;
import com.turkcell.library_cqrs.domain.book.model.BookId;

import java.util.Optional;

public interface BookRepository {

    Book save(Book book);
    Optional<Book> findById(BookId bookId);


}
