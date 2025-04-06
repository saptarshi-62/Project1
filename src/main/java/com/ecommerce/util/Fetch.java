package com.ecommerce.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderDetail;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;

public class Fetch {
	 private SessionFactory sessionFactory;

	    public Fetch(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;

	        Session session = sessionFactory.getCurrentSession();
	        session.beginTransaction();

	        // Fetch all OrderDetails
	        List<OrderDetail> orderDetailsList = session.createQuery("from OrderDetails", OrderDetail.class).getResultList();

	        for (int i = 0; i < orderDetailsList.size(); i++) {
	            OrderDetail od = orderDetailsList.get(i);

	            Order order = od.getOrders();     // Get Order
	            User user = order.getUsers();      // Get User from Order
	            Product product = od.getProduct(); // Get Product from OrderDetails

	            System.out.println("Order ID: " + order.getId());
	            System.out.println("User Name: " + user.getUsername());
	            System.out.println("Product Name: " + product.getName());
	            System.out.println("Quantity: " + od.getQuantity());
	            System.out.println("Unit Price: " + od.getUnitPrice());
	            System.out.println("----------------------------------");
	        }
	        //commit and close
	        session.getTransaction().commit();
	        session.close();
	    }
}
