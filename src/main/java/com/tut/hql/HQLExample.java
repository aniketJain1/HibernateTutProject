package com.tut.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();

		// HQL
		// Syntax
		String query = "from Student as s where s.city=:x and s.name=:y";

		Query<Student> q = s.createQuery(query);
		q.setParameter("x", "mumbai");
		q.setParameter("y", "shri");

		// single - (unique)
		// multiple-list

		List<Student> list = q.list();
		
		System.out.println("a");

		for (Student student : list) {
			System.out.println(student.getName() + " " + student.getCity());
		}
		
		s.close();

	}
}
