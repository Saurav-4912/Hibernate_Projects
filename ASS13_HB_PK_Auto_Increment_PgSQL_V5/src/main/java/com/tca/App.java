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
			configuration.configure("hibernate.cfg.xml");

			configuration.addAnnotatedClass(Student.class);

			sf = configuration.buildSessionFactory();
			session = sf.openSession();

			txn = session.beginTransaction();

			Student student = new Student();
			student.setName("AAA");
			student.setPer(80.0);
			int trno = (int) session.save(student);
			System.out.println("Record saved for Roll Number : " + trno);

			txn.commit();

			System.out.println("Data is saved Successfully !!");

		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();

		} finally {
			session.close();
			sf.close();
		}
	}
}
