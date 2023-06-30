package com.tut.hql;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.tut.Student;
import com.tut.mapping_one_to_many.Question;

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
		
		System.out.println("===============================");
		
		
		Transaction tx = s.beginTransaction();
		
//		 Delete query
//		Query<Student> q2 = s.createQuery("delete from Student as s where s.city=:c");
//		q2.setParameter("c", "hyd");
//		int r = q2.executeUpdate();
//		System.out.println("Deleted: "+ r);
		
//		Update Query
//		Query q2 = s.createQuery("update Student set city=:c where name=:n");
//		q2.setParameter("c", "nagpur");
//		q2.setParameter("n", "aniket");
//		
//		int r = q2.executeUpdate();
//		System.out.println("Updated : "+ r);
		
		tx.commit();
		
//		how to execute join query
		Query q3 = s.createQuery("select q.question , q.questionId, q.answers from Map_Many_To_One_Question as q INNER JOIN q.answers as a");
		
		List<Object []> list3 = q3.getResultList();
		
		for(Object[] arr : list3) {
			System.out.println(Arrays.toString(arr));
		}
		
		s.close();
		factory.close();

	}
}
