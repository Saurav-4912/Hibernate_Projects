package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) 
	{
		Configuration configuration = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction txn = null;
		
		Configuration configuration2 = null;
		SessionFactory sf2 = null;
		Session session2 = null;
		Transaction txn2 = null;

		try 
		{
			
			// For MYSQL
			configuration = new Configuration();
			configuration.configure("mysql.cfg.xml"); // Load and parse XML file
			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();
			//-------------------------------------------------------------------------------
			//For POSSTGRESQL
			configuration2 = new Configuration();
			configuration2.configure("postgre.cfg.xml"); // Load and parse XML file
			sf2 = configuration2.buildSessionFactory();
			session2 = sf2.openSession();
			txn2 = session2.beginTransaction();

			Student student = new Student();
			student.setRno(101);
			student.setName("AAA");
			student.setPer(70.0);
			
			session.persist(student);  // MYSQL
			session2.persist(student); //POSTGRESQL
			
			Teacher teacher = new Teacher();
			teacher.setTno(111);
			teacher.setTname("ZZZ");
			teacher.setSalary(25000.0);
			
			session.persist(teacher); // MYSQL
			session2.persist(teacher); //POSTGRESQL
			
// Save and Persist method both doing same means save record into table
// but save method return primary key.
// persist method does not return anything.
			
			/*
			Integer temp = (Integer) session.save(student);
			
			System.out.println("Record saved for rno : " + temp);
			*/
			
			
			

			txn.commit();  // MYSQL
			txn2.commit(); //POSTGRESQL
			System.out.println("Data saved successfully");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			txn.rollback();    // MYSQL
			txn2.rollback();  //POSTGRESQL
		} 
		finally
		{
			session.close();  // MYSQL
			sf.close();        // MYSQL
			
			session2.close();  //POSTGRESQL
			sf2.close();    //POSTGRESQL
		}

	}
}
