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
	public static void main(String[] args) 
    {
    	 Configuration configuration = null;
    	 SessionFactory sf =null;
    	 Session session=null;
    	 Transaction txn=null;
    	
    	 try
    	 {
    	        configuration = new Configuration(); // conf--> data
    	        configuration.configure();           // load & parse XML files s -> user:root dname:hfb02 pwd=root
                
    	        sf = configuration.buildSessionFactory();
    	        session = sf.openSession();
       
    	        txn = session.beginTransaction();
        
    	        Student ob = new Student();  //rno: null name:null per:null
    	        
    	        ob.setRno(101);
    	        ob.setName("AAA");
    	        ob.setPer(60.0);
               
    	        session.save(ob);   // hibernate is database independent 
    	        					// bcz save() can save reocord in any type of database.
    	                            // It prepare INSERT sql with the help of Dialect class
    	        
    	        
    	       
    	        
    	        txn.commit();
    	        System.out.println("Data is Saved Successfully !!!");
    	 }
    	 catch(Exception e)
    	 {
    		e.printStackTrace();
    		txn.rollback();
    	 }
    	 finally
    	 {
    		 session.close();
    		 sf.close();
    	 }
        
        
        
    }
	
}
