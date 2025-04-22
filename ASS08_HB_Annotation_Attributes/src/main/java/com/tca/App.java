package com.tca;

import javax.naming.directory.InvalidAttributesException;

import org.hibernate.Session;
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App {

	public static Student addData(Integer rno, String name, Double per, String email)
			throws InvalidAttributesException {

		if (per < 0 || per > 100) {
			throw new InvalidAttributesException("Percentage Should be between 0 and 100");
		}

		Student student = new Student();
		student.setRno(rno);
		student.setName(name);
		student.setPer(per);
		student.setEmail(email);

		return student;
	}

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

			Student student = addData(111, "AAA", 80.0, "aaa@gmail.com");

			session.save(student);

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
