package com.tut.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CascadeExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		Question q1 = new Question();
		q1.setQuestionId(568);
		q1.setQuestion("What is java...?");
		
		Answer a1 = new Answer(8365,"Popular prog lang", q1);
		Answer a2 = new Answer(8364,"Second answer", q1);
		Answer a3 = new Answer(8366,"third answer", q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		Transaction tx = s.beginTransaction();
		
		s.persist(q1);
		
		// No need to this, if you use cascade
//		s.persist(a1);
//		s.persist(a2);
//		s.persist(a3);
		
		
		tx.commit();
		
		s.close();
		factory.close();
	}
}
