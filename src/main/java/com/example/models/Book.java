package com.example.models;

import javax.persistence.*;

@Entity(name="Book")
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;

    private String name;

    private String subName;

    private String serName;

    private String isbn;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                ", serName='" + serName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }

    public Book(String name, String isbn, String subName) {
        this.name = name;
        this.isbn = isbn;
        this.subName = subName;
    }
    public Book() {
    }

}
