package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		// get()
		Student student = session.get(Student.class, 102);
		System.out.println(student);
		Student student1 = session.get(Student.class, 103); // use Session Caches object.
//		System.out.println(student1);
		
		System.out.println("\n----------------------------\n");
		
		// load()
		Address address = session.load(Address.class, 1);
//		System.out.println(address);
		System.out.println("------------------------");
		Address address1 = session.load(Address.class, 1);
		System.out.println(address1);
		
		
		session.close();
		factory.close();
	}
}
