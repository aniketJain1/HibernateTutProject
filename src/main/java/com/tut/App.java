package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
        System.out.println( "Project started..." );
        
        Configuration cfg = new Configuration();
//      cfg.configure("hibernate.cfg.xml");
        cfg.configure();
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student st = new Student();
        st.setId(102);
        st.setName("Aniket Jain");
        st.setCity("Nagpur");
        System.out.println(st);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
//        session.save(st);
        session.persist(st);
        tx.commit();
        session.close();
    }
}
