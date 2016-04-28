package com.epam.DB.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Title")
    String title;

    @Column(name = "Author")
    String author;

    @Column(name = "Bookstore")
    Bookstore bookstore;

    @Column(name = "Category")
    Category category;

    public Book() {
    }

    public Book(String author, String title, Bookstore bookstore, Category category) {
        this.author = author;
        this.title = title;
        this.bookstore = bookstore;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @ManyToOne
    @Column(name = "books_store")
    public Bookstore getBookstore() {
        return bookstore;
    }

    public void setBookstore(Bookstore bookstore) {
        this.bookstore = bookstore;
    }

    @ManyToOne
    @Column(name = "books_cat")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
