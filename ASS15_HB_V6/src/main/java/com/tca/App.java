package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

			Student student = new Student();
			student.setRno(999);
			student.setName("AAA");
			student.setPer(70.0);

			// The method save(Object) from the type Session is deprecated since version 6.0
//			int rno = (Integer) session.save(student);
//			
//			System.out.println("SAVED : " + rno);

			session.persist(student);

			int rno = (int) session.getIdentifier(student);

			System.out.println("SAVED : " + rno);

			txn.commit();
			System.out.println("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();

		} finally {
			session.close();
			sf.close();
		}

	}
}
