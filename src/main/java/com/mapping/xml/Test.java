package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Person person = new Person(283, "Ani", "Nagpur", "3139187121");
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		// don't use session.persist(person); 
		session.save(person);
		
		tx.commit();
		session.close();
		factory.close();

	}

}
