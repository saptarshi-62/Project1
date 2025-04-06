package com.ecommerce.util;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;

//import jakarta.persistence.Query;

public class createProduct {
	private SessionFactory sessionFactory = null;

	public createProduct(SessionFactory sessionFactory) {
		// set the object
		this.sessionFactory = sessionFactory;

		// Session object using SessionFactory object
		Session session = sessionFactory.getCurrentSession();

		// start the transaction
		session.beginTransaction();

		// Fetch categories 
		Query<Category> query = session.createQuery("FROM Category", Category.class);
        					   query.setMaxResults(3);
        List<Category> cat = query.getResultList();

        if (cat.size() < 3) 
        {
        	System.out.println("Sorry, not enough categories found to create products.");
        	return;
        }

        Category c1 = cat.get(0);
        Category c2 = cat.get(1);
        Category c3 = cat.get(2);
		
		// Create and persist products under those categories
		Product p1 = new Product("Smartphones",new BigDecimal("1455.0"),30,c1);
		Product p2 = new Product("Rice",new BigDecimal("450.0"),10,c2);
		Product p3 = new Product("fridge",new BigDecimal("8000.0"),20,c3);

		// Persist all products
		session.persist(p1);
		session.persist(p2);
		session.persist(p3);
		
		// Print confirmation
		System.out.println("Products are created successfully.");

		// commit
		session.getTransaction().commit();

		// close the session object
		session.close();
	}
}
