package com.tca;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.ContactNumber;
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

			//---------------------------Component-------------------------------------------
		/*
			ContactNumber contact = new ContactNumber();
			contact.setCountryCode(91);
			contact.setContactNumber("1122334455");
			
			Student student = new Student();
			student.setRno(101);
			student.setName("AAA");
			student.setPer(78.90);
			student.setCity("PUNE");
			student.setContact(contact);
			
			session.save(student);
		*/
			
			Student student = session.get(Student.class, 101);
			
			System.out.println("Roll Number : " + student.getRno());
			System.out.println("Name        : " + student.getName());
			System.out.println("Percentage  : " + student.getPer());
			System.out.println("City        : " + student.getCity());
			System.out.println("Contact Info: +" + student.getContact().getCountryCode() + "-" + student.getContact().getContactNumber());
			
			
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
