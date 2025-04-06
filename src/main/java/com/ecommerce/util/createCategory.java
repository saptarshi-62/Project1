package com.ecommerce.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.entity.Category;

public class createCategory {
	private SessionFactory sessionFactory = null;
	public createCategory(SessionFactory sessionFactory)
	{
		//set the object
		this.sessionFactory = sessionFactory;
		//Session object using SessionFactory object
		Session session =  sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//create objects for Category and Product
		Category category1 = new Category("Electronics","Devices including Laptops, Headphones and many more");
		session.persist(category1);
		System.out.println("Category is created successfully with id " + category1.getId());
		
		//more instances of them
		 Category category2 = new Category("Grocery","Everyday's need items");
	     session.persist(category2);
		 System.out.println("Category is created successfully with id " + category2.getId());
		 
		 Category category3 = new Category("Appliances","Home appliances like fridge, washing machine and many more");
	     session.persist(category3);
		 System.out.println("Category is created successfully with id " + category3.getId());
		 //commit
		 session.getTransaction().commit();
		 //close the session object
		 session.close();
	}
}
