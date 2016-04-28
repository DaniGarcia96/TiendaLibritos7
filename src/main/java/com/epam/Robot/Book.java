package com.epam.Robot;

import java.net.URL;

/**
 * Created by aga on 28.04.16.
 */
public class Book {

    private String title, author;
    String bookCategory;
    String bookstore;



    Book(String title, String author, String bookCategory, String bookstore) {
        this.title = title;
        this.author = author;
        this.bookCategory = bookCategory;
        this.bookstore = bookstore;
    }



    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String category) {
        this.bookCategory = category;
    }

}
