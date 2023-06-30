package com.tut.sqlquery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		// SQL Query
		
		String q = "select * from student";

//		NativeQuery<Student> nq = s.createNativeQuery(q, Student.class);
//
//		List<Student> list = nq.list();
//
//		for (Student student : list) {
//			System.out.println(student.getName() + " : " + student.getCity());
//		}
		
//		OR


		NativeQuery nq = s.createNativeQuery(q);

		List<Object[]> list = nq.list();

		for (Object[] student : list) {
			System.out.println(student[2] + " : " + student[1]);
		}

		s.close();
		factory.close();
	}
}
