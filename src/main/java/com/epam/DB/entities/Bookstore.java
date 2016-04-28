package com.epam.DB.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by aga on 27.04.16.
 */
@Entity
@Table (name = "bookstore")
public class Bookstore implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "bookstore")
    String name;

    @Column (name = "address")
    String urlAddress;

    @Column (name = "books")
    ArrayList<Book> listOfBooks;

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

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    @OneToMany
    @JoinColumn (name = "books_store")
    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
