package com.example.models;

import lombok.*;

import javax.persistence.*;


@Entity(name="Book")
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;

    private String name;

    private String subName;

    private String serName;

    private String isbn;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher;

}
