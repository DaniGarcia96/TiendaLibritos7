/**
 * Sample Skeleton for 'BookstoreOverview.fxml' Controller Class
 */

package com.epam.GUI.view;

import com.epam.GUI.model.Bookstore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.HashSet;
import java.util.Set;

public class BookstoreOverviewController {
    Bookstore data = new Bookstore();
    Set <String> categoriesToShow = new HashSet<>();
    @FXML
    private CheckBox romanceCat;
    @FXML
    private CheckBox itCat;
    @FXML
    private CheckBox fantasyCat;
    @FXML
    private CheckBox otherCat;

    @FXML // fx:id="bookstores"
    private ListView<String> bookstores; // Value injected by FXMLLoader
    private ObservableList<String> listViewBookstores = FXCollections.observableArrayList(data.initBookstoreList);


    @FXML // fx:id="activeLibraries"
    private ListView<String> activeLibraries; // books according to init list, items added/rm via buttons
    private ObservableList<String> listViewActiveBookstores = FXCollections.observableArrayList();


    @FXML // fx:id="listOfBooks"
    private TextArea listOfBooks;

    @FXML // fx:id="libraryURL"
    private TextField libraryURL;

    /**
     * creates list of bookstores choosed to show their free books
     */
    @FXML
    private void rightButtonAction() {
        String selectedItem = bookstores.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listViewBookstores.remove(selectedItem);

            listViewActiveBookstores.add(selectedItem);
        }
    }
    /**
     * creates list of bookstores choosed to show their free books, deleting elements from it
     */
    @FXML
    private void leftButtonAction() {
        String selectedItem = activeLibraries.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listViewActiveBookstores.remove(selectedItem);
            listViewBookstores.add(selectedItem);
        }
    }
    /**
     * deletes bookstore from initial list of bookstores, but only in GUI, doesn't affect DB
     */
    @FXML
    private void delButtonAction() {
        String selectedItem = bookstores.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listViewBookstores.remove(selectedItem);
        }
    }
    /**
     * adds bookstore to the list. Present in DB.
     */
    @FXML
    private void addButtonAction(ActionEvent action) {
        String typedURL = libraryURL.getText();
        if (typedURL != null) {
            listViewBookstores.add(typedURL);
            libraryURL.clear();
        }
    }
    /**
     * creates list of categories of free books choosed to be showed
     */
    @FXML
    private void handleCheckBox(ActionEvent action) {
        if (romanceCat.isSelected()) {
            categoriesToShow.add(romanceCat.getText());
        } else categoriesToShow.remove(romanceCat.getText());

        if (fantasyCat.isSelected()) {
            categoriesToShow.add(fantasyCat.getText());
        } else categoriesToShow.remove(fantasyCat.getText());

        if (itCat.isSelected()) {
            categoriesToShow.add(itCat.getText());
        } else categoriesToShow.remove(itCat.getText());

        if (otherCat.isSelected()) {
            categoriesToShow.add(otherCat.getText());
        } else categoriesToShow.remove(otherCat.getText());

    }

    /**
     * initializes book crawling with given settings (selected categories, bookstores)
     */
    @FXML
    private void showBooksButtonAction(ActionEvent action) {
        setText(categoriesToShow.toString());
    }
    public void setText(String text) {
        listOfBooks.setText(text);
    }

    @FXML
    void initialize() {
        bookstores.setItems(listViewBookstores);
        activeLibraries.setItems(listViewActiveBookstores);
        romanceCat.setOnAction(e -> handleCheckBox(e));
        itCat.setOnAction(e -> handleCheckBox(e));
        fantasyCat.setOnAction(e -> handleCheckBox(e));
        otherCat.setOnAction(e -> handleCheckBox(e));
    }
}
