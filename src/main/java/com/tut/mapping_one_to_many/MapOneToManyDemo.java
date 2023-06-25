package com.tut.mapping_one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapOneToManyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
//		//Creating Question
//		Question q1 = new Question();
//		q1.setQuestionId(101);
//		q1.setQuestion("What is java ?");	
//		
//		//Creating Answer
//		Answer a1 = new Answer();
//		a1.setAnswerId(1258);
//		a1.setAnswer("Java is a Programming Language.");
//		a1.setQuestion(q1);
//		
//		Answer a2 = new Answer();
//		a2.setAnswerId(1259);
//		a2.setAnswer("With the help of java we can create sofwares.");
//		a2.setQuestion(q1);
//		
//		Answer a3 = new Answer();
//		a3.setAnswerId(1260);
//		a3.setAnswer("Java has different type of frameworks.");
//		a3.setQuestion(q1);
//		
//		List<Answer> list = new ArrayList<Answer>();
//		list.add(a1);
//		list.add(a2);
//		list.add(a3);		
		
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		//save
//		session.persist(q1);
//		session.persist(a1);
//		session.persist(a2);
//		session.persist(a3);
//		
//		tx.commit();
		
		//fetching......
		Question newQ = session.get(Question.class, 101);
		System.out.println(newQ.getQuestion());
		
		for ( Answer a : newQ.getAnswers())
		{
			System.out.println(a.getAnswer());
		}
		
		session.close();
		factory.close();
	}
}
