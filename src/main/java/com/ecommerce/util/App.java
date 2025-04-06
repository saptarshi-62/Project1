package com.ecommerce.util;

import org.hibernate.SessionFactory;

public class App {
    public static void main(String[] args) {
        // Get SessionFactory and open a session
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //new createCategory(sessionFactory);
        //new createProduct(sessionFactory);
        //new createUser(sessionFactory);
        new createOrder(sessionFactory);
        //new Fetch(sessionFactory);
    }
}
