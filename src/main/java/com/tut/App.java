package com.tut;

import java.io.IOException;
import java.util.Date;

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
	public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started..." );
        
        Configuration cfg = new Configuration();
//      cfg.configure("hibernate.cfg.xml");
        cfg.configure();
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student st = new Student();
        st.setId(103);
        st.setName("Aniket Jain");
        st.setCity("Nagpur");
        System.out.println(st);
        
        Address address = new Address();
        address.setStreet("Street1");
        address.setCity("Nagpur");
        address.setAddeDate(new Date());
        address.setOpen(true);
        address.setX(455.046);
        
//        FileInputStream fis = new FileInputStream("src/main/java/icon.png");
//        byte[] data = new byte[fis.available()];
//        fis.read(data);
//        address.setImage(data);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
//        session.save(st);
        session.persist(st);
        session.persist(address);
        
        tx.commit();
        
        session.close();
        
        System.out.println("Done...");
    }
}
