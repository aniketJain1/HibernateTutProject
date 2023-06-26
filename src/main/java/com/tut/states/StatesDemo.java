package com.tut.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StatesDemo {

	public static void main(String[] args) {
		
		//  ======== #1 ==============
		StudentStates st = new StudentStates();
		StudentStates st2 = new StudentStates();
		st.setId(101);
		st.setName("Aniket");
		st.setCity("Nagpur");
		System.out.println(st);
		// student : Transient state = obj not associated with session and DB
		// ==========================================
		
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		// ========== #2 ===================
		session.persist(st);
		//student : Persistent State = obj associated with session and DB
		//====================================
		
		//		st.setName("Sumit");
		
		tx.commit();
		
		// ================= #3 ===========================
		session.close();
		//Student : Detached State = obj only associated with DB not with Session
		// that's mean we can do only fetching things
		//================================================
		
		// ========= can not do this because session is closed. =========
//		session.persist(st);
		// ======= AND ==============
//		st.setId(102);
//		st.setName("Vishal");
//		session.persist(st);
		//=============================================
		
//		st.setCity("Nashik");
//		session.merge(st);
		//==============================================
		
		System.out.println(st);
		
		Session session2 = factory.openSession();
		Transaction tx2 = session2.beginTransaction();
		st.setCity("Nashik");
		st.setName("Vishal");
		System.out.println(st);
		
		session2.merge(st);
		
		st2.setId(102);
		st2.setCity("Pune");
		st2.setName("Sumit");
		System.out.println(st2);
		
		session2.persist(st2);
		
		// =========== #4 =====================
		// get student or make and performed delete
		session2.remove(st2);
		System.out.println(st2);
		// Student : Removed State = only associated with session but not with DB
		//=================================

		tx2.commit();
		session2.close();
		
		
		
		factory.close();
		
		
	}
}
