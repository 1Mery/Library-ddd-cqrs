package com.turkcell.library_cqrs.domain.book.model;

import java.util.Objects;

public class Book {

    private final BookId id;
    private String title;
    private Author author;
    private String isbn;
    private Integer year;
    private String publisher;

    private Book(BookId id, String title, Author author, String isbn, Integer year, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.publisher = publisher;
    }

    public static Book create(String title,Author author,String isbn, Integer year, String publisher){
        validateTitle(title);
        Objects.requireNonNull(author,"Author cannot be null");
        validateIsbn(isbn);
        validateYear(year);
        validatePublisher(publisher);

        return new Book(BookId.generate(),title,author,isbn,year,publisher);
    }

    private static void validateTitle(String title) {
        if (title.isEmpty())
            throw new IllegalArgumentException("Title cannot be null");
    }

    private static void validateIsbn(String isbn){
        if (isbn.isEmpty()){
            throw new IllegalArgumentException("Isbn cannot be null");
        }
    }

    private static void validateYear(Integer year){
        if (year==null||year<=0)
            throw new IllegalArgumentException("Year cannot be negative or null");
    }

    private static void validatePublisher(String publisher){
        if (publisher.isEmpty())
            throw new IllegalArgumentException("Publisher cannot be null");
    }

    public BookId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }


}
