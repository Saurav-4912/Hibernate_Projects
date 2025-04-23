package com.tca;

import java.util.List;
import java.util.Scanner;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//
//import javax.persistence.Query;
import org.hibernate.query.Query;

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

			//-------------------------------------------------------------------------------
		
			// Pagination
			
			Scanner sc = new Scanner(System.in);
			
			Query query = session.createQuery("from Student");
			
			query.setMaxResults(4);
			
			for(int i = 0 ; i <= 9 ; i = i+3) {
				
				query.setFirstResult(i);
				List<Student> list = query.list();
				
				for(Student s : list) {
					System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
				}
				System.out.println("----------------------------------");
				
				System.out.println("Press any key to continue......");
				sc.next();
			}
			
			//--------------------------------------------------------------------------------

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
