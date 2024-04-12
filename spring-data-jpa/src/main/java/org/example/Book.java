package org.example;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Title title;

    @ManyToMany
    private Set<Author> authors;

    private BookType type;
    @Transient
    private LocalDateTime dataFreshness = LocalDateTime.now();

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public Book() {
    }

    public Book(Title title, Set<Author> authors, BookType type) {
        this.title = title;
        this.authors = authors;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title=" + title +
                ", authors=" + authors +
                ", type=" + type +
                ", dataFreshness=" + dataFreshness +
                '}';
    }
}
