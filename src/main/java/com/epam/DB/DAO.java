package com.epam.DB;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aga on 28.04.16.
 */
public class DAO {

    public static void main(String[] args) {
        DAO test = new DAO();
        Set<String> categories = new HashSet<>();
        categories.add("IT");
        System.out.println(test.setTextArea(categories, null));
    }

    public static String setTextArea(Set<String> categoriesToShow, Set<String> bookstoresToShow) {
        String result = "";
        StringBuilder prepareResult = new StringBuilder();
        Session session = HibernateUtil.getSessionFactory().openSession();

        for(String category: categoriesToShow){
            Query query = session.createQuery("from Category where name = '"+category+"'");
            List list = query.list();
            prepareResult = prepareResult.append(query.list().toString());
        }
        session.close();
        return result = prepareResult.toString();
    }

}
