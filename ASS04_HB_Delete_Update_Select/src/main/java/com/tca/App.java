package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
    	
    	
    	Configuration configuration = null;
    	
    	SessionFactory sf = null;
    	
    	Session session = null;
    	
    	Transaction txn =null;
    	
    	try {
    		configuration = new Configuration();
    		configuration.configure();
    		
    		sf = configuration.buildSessionFactory();
    		
    		session = sf.openSession();
    		
    		txn = session.beginTransaction();
    		
    		
    		// Update method if record is available
    		/**
    		Student student = new Student();
    		student.setRno(102);
    		student.setName("BBB");
    		student.setPer(78.00);
    		
    		session.update(student);
    		*/
    		
    		
    		
    		// Update Method if record is not available (org.hibernate.StaleStateException)
    		/**
    		Student student = new Student();
    		student.setRno(103);
    		student.setName("CCC");
    		student.setPer(90.00);
    		
    		session.update(student);  // org.hibernate.StaleStateException this exception got bcoz record is not available 
    		*/
    		
    		
    		
    		// SaveOrUpdate Method if record is not available
    		/**
    		Student student = new Student();
    		student.setRno(103);
    		student.setName("CCC");
    		student.setPer(90.00);
    		
    		session.saveOrUpdate(student);
    		*/
    		
    		
    		// SaveOrUpdate method if record is available
    		//select student_.RNO, student_.NAME as NAME0_, student_.PER as PER0_ from student student_ where student_.RNO=?
    	    /**
    		Student student = new Student();
    		student.setRno(103);
    		student.setName("CCC");
    		student.setPer(80.00);
    		
    		session.saveOrUpdate(student);
    		*/
    		
    		
    		
    		// Delete Method (if record is not available then delete will not generate an exception
    		/**
    		Student student = new Student();
    		student.setRno(103);
    		
    		session.delete(student);
    		*/
    		
    		
    		
    		
    		// Get and Load Method - To read/retrive/fetch a record from database and store into object.
    		
    		
    		// 1. Get Method (Early Loading) (If ID is present then it returns object otherwise return null(java.lang.NullPointerException).)
    		/**
    		Student student = (Student) session.get(Student.class, 103);
    		
    		System.out.println("Roll Number : " + student.getRno());
    		System.out.println("Name        : " + student.getName());
    		System.out.println("Percentage  : " + student.getPer());
    		*/
    		
    		// 2. Load Method (Lazy Loading) (If ID is present then it return object otherwise it gives "ObjectNotFoundException").
    		
	        Student student = (Student) session.get(Student.class, 102);
    		
    		System.out.println("Roll Number : " + student.getRno());
    		System.out.println("Name        : " + student.getName());
    		System.out.println("Percentage  : " + student.getPer());
    		
    		
    		
    		txn.commit();
    		System.out.println("Successfully !!!");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		txn.rollback();
    	}
    	finally {
    		session.close();
    		sf.close();
    	}
    	
      
    }
}
