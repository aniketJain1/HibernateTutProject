package com.tut.mapping_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapOneToOneDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
//		//Creating Question
//		Question q1 = new Question();
//		q1.setQuestionId(101);
//		q1.setQuestion("What is java ?");		
//		//Creating Answer
//		Answer a1 = new Answer();
//		a1.setAnswerId(1101);
//		a1.setAnswer("Java is a Programming Language.");
//		
//		q1.setAnswer(a1);
//		a1.setQuestion(q1);
//		
//		//Creating Question
//		Question q2 = new Question();
//		q2.setQuestionId(102);
//		q2.setQuestion("What is Collection ?");		
//		//Creating Answer
//		Answer a2 = new Answer();
//		a2.setAnswerId(1102);
//		a2.setAnswer("API to work with objects in java.");
//		
//		q2.setAnswer(a2);
//		a2.setQuestion(q2);
		
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
		
//		session.persist(q1);
//		session.persist(a1);
//		
//		session.persist(q2);
//		session.persist(a2);
		
//		tx.commit();
		
		//fetching......
		Question newQ = session.get(Question.class, 101);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		
		session.close();
		factory.close();
	}
}
