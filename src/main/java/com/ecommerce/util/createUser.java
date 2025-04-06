package com.ecommerce.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import com.ecommerce.entity.User;
import com.ecommerce.entity.UserRole;

public class createUser {
	private SessionFactory sessionFactory = null;

	public createUser(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		// Create Users
		User u1 = new User("Raman Bharadwaj", "secure467", "Bhar89@gmail.com", UserRole.CUSTOMER);
		User u2 = new User("Shristi Das", "kijh467", "Das805@gmail.com", UserRole.ADMIN);

		// Save Users
		  try {
	            session.persist(u1);
	        } catch (ConstraintViolationException e) {
	            System.out.println("Duplicate user (Raman Bharadwaj). Not inserted.");
	        }

	        try {
	            session.persist(u2);
	        } catch (ConstraintViolationException e) {
	            System.out.println("Duplicate user (Shristi Das). Not inserted.");
	        }

		System.out.println("User inserted successfully with 1st ID: " + u1.getId());
		System.out.println("User inserted successfully with 2nd ID: " + u2.getId());

		session.getTransaction().commit();
		session.close();
	}
}
