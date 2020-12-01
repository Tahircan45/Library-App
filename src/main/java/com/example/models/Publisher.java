package com.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Publisher")
@Table(name = "publisher")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Publisher() {
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
