package com.epam.DB.initDB;

import com.epam.DB.HibernateUtil;
import com.epam.DB.entities.Bookstore;
import com.epam.DB.entities.Category;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by aga on 28.04.16.
 */
public class ManageCategoriesAndBookstores {


    private static String categoriesPath = "src/Keywords/categories";
    private static String bookstoresPath = "src/Keywords/bookstores";

    public static void main(String[] args) {
        setDatabase();
    }
    /**
     * method using categories to put them into DB @see categoriesFetcher
     */
    private static void setDatabase() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        ArrayList<String> listOfCategories = (ArrayList<String>) categoriesFetcher(categoriesPath);
        ArrayList<String> listOfBookstores = (ArrayList<String>) categoriesFetcher(bookstoresPath);

        for (String string : listOfCategories) {
            Category category = new Category();
            category.setName(string);

            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }
        for (String string : listOfBookstores) {
            Bookstore bookstore = new Bookstore();
            bookstore.setName(string);

            session.beginTransaction();
            session.save(bookstore);
            session.getTransaction().commit();
        }
        session.close();
    }

    private static List<String> categoriesFetcher(String fileName) {
        List<String> entriesList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            entriesList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entriesList;
    }

}
