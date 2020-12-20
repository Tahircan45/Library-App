package com.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Publisher")
@Table(name = "publisher")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Publisher {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String description;

    @OneToMany(
            mappedBy = "publisher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Book> books = new ArrayList<>();
}
