package com.epam.GUI.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by aga on 27.04.16.
 */
public class Category {
    private final ArrayList<String> categories = new ArrayList<>();
    public ObservableList<String> initCategories = FXCollections.observableList(categories);

    public Category(){
        categories.add("IT");
        categories.add("Fantasy");
        categories.add("Romance");

    }
}
