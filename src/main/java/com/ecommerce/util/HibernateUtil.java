package com.ecommerce.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.OrderDetail;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Category.class)
        .addAnnotatedClass(Product.class)
        .addAnnotatedClass(Order.class)
        .addAnnotatedClass(User.class)
        .addAnnotatedClass(OrderDetail.class)
        .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}