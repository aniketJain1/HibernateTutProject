package com.tut.embedding;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		StudentEm st1 = new StudentEm();
		st1.setId(101);
		st1.setName("Aniket");
		st1.setCity("Nagpur");
		
		CertificateEm certi1 = new CertificateEm();
		certi1.setCourse("Java");
		certi1.setDuration("1.5 Months");
		
		st1.setCerti(certi1);
		

		StudentEm st2 = new StudentEm();
		st2.setId(102);
		st2.setName("Sumit");
		st2.setCity("Delhi");
		
		CertificateEm certi2 = new CertificateEm();
		certi2.setCourse(".Net");
		certi2.setDuration("2 Months");
		
		st2.setCerti(certi2);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//Object Save
		s.persist(st1);
		s.persist(st2);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
