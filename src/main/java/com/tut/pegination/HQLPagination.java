package com.tut.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;


public class HQLPagination {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Query query = s.createQuery("from Student",Student.class);
		
		//Implementing pagination using hibernate
		
//		query.setFirstResult(0); // starting from index zero
//		
//		query.setMaxResults(2); // how much elements in a time, in one page, (like page size)
		
		query.setFirstResult(2);
		
		query.setMaxResults(3); 
		
		List<Student> list = query.list();
		
		for(Student st : list) {
			System.out.println(st.getId()+" : "+ st.getName()+" : "+ st.getCity());
		}
		
		s.close();
		factory.close();
	}

}
