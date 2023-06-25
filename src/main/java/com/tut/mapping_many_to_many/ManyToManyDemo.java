package com.tut.mapping_many_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

	public static void main(String[] args) {
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(101);
		e1.setName("Aniket");
		e2.setEid(102);
		e2.setName("Sumit");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(501);
		p1.setProject("Book Management Application...");
		p2.setPid(502);
		p2.setProject("Library Management Application...");
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p2.setEmps(list1);
		
//		e2.setProjects(list2);
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.persist(e1);
		session.persist(e2);
		session.persist(p1);
		session.persist(p2);
		
		tx.commit();
		session.close();
		factory.close();
		
	}
}
