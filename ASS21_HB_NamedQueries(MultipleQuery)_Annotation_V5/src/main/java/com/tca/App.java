package com.tca;

import javax.persistence.Query;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.tca.entities.Student;

public class App {
	public static void main(String[] args) {
		Configuration configuration = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction txn = null;

		try {

			configuration = new Configuration();
			configuration.configure();

			configuration.addAnnotatedClass(Student.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();

			//---------------------------Named Queries-------------------------------------------
		
		/*
			// Code : @NamedQuery(name="GET_ALL_INFO", query="from Student")
			Query query = session.getNamedQuery("GET_ALL_INFO");
			
			List<Student> list = query.getResultList();
			
			for(Student s : list) {
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				System.out.println("----------------------------");
			}
		*/
			
		/*
			// Code : @NamedQuery(name="GET_CITYWISE", query= "from Student where city = :abc ")
			Query query = session.getNamedQuery("GET_CITYWISE");
			
			query.setParameter("abc", "PUNE");
			
			List<Student> list = query.getResultList();
			
			for(Student s : list) {
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				System.out.println("----------------------------");
			}
		*/
		/*
			// Code : @NamedQuery(name="UPDATE_STUDENT_CITY" , query = "update Student set city= :abc where city= :pqr ")
			Query query = session.getNamedQuery("UPDATE_STUDENT_CITY");
			
			query.setParameter("abc", "POONA");
			query.setParameter("pqr", "PUNE");
			
			int count = query.executeUpdate();
			
			System.out.println("No. of records updated : " + count);
			
		*/
		
		/*
			// Code : @NamedQuery(name="DELETE_STUDENT" , query = "delete from Student where rno = :rollNumber")
			Query query = session.createNamedQuery("DELETE_STUDENT");
			
			query.setParameter("rollNumber", 101);
			
			int count = query.executeUpdate();
			System.out.println("No. of records updated : " + count);
		
		*/
			
		/*
			// Code : @NamedQuery(name="GET_COUNT", query = "select count(*) from Student")
			  Query query = session.createNamedQuery("GET_COUNT");
			
			  Long count =  (Long) query.getSingleResult();
			  
			  System.out.println("Total Number or record : " + count);
		*/	  
			  
			
			
			// ---------------------------------------------------------------------------------------------
			txn.commit();
			System.out.println("Done !!");

		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();

		} finally {
			session.close();
			sf.close();
		}

	}
}
