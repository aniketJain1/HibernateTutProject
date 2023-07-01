package com.tut.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// by default enable
		//First level cache
		
		Student student = session.get(Student.class, 101); // query fire
		System.out.println(student);
		
		Student student1 = session.get(Student.class, 101);
		// query not fire again, bcz same obj, first check to session, whether  this same obj present or not
		// if it is present then query not fire again
		System.out.println(student1);
		
		System.out.println(session.contains(student1));// is obj is present in session cache (first level cache) or not ?
		
		session.close();
		factory.close();
	}

}
