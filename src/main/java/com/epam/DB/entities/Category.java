package com.epam.DB.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by aga on 27.04.16.
 */
@Entity
@Table (name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "category", unique = true)
    String name;

    @Column (name = "books")
    ArrayList <Book> listOfBooks;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany
    @JoinColumn (name = "books_cat")
    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
