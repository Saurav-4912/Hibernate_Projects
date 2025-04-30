package com.tca;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Employee;
import com.tca.entities.Executive;


public class App {
	public static void main(String[] args) {
		Configuration configuration = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction txn = null;

		try {

			configuration = new Configuration();
			configuration.configure();

			sf = configuration.buildSessionFactory();
			session = sf.openSession();
			txn = session.beginTransaction();

			//---------------------------Inheritance : Table per class -------------------------------------------
	    /*	
			// Inserting data
			Employee employee = new Employee();
			employee.setEid(101);
			employee.setEname("PPP");
			session.save(employee);
			
			Executive executive = new Executive();
			executive.setEid(222);
			executive.setEname("QQQ");
			executive.setErole("Developer");
			session.save(executive);
		*/
		/*	
			Employee employee = session.get(Employee.class, 222);
			
			System.out.println("Employee Information");
			System.out.println("Employee Id   : " + employee.getEid());
			System.out.println("Employee Name : " + employee.getEname());
		*/

		/*
			Employee employee = session.get(Employee.class, 101);
			
			System.out.println("Employee Information");
			System.out.println("Employee Id   : " + employee.getEid());
			System.out.println("Employee Name : " + employee.getEname());
		*/
		/*	
			// Here we can not access executive role because here we use inheritance means we keep parent cha reference child madhe thevla

			Employee employee = session.get(Executive.class, 222);
			
			System.out.println("Employee Information");
			System.out.println("Employee Id   : " + employee.getEid());
			System.out.println("Employee Name : " + employee.getEname());
			//System.out.println("Employee Name : " + employee.getErole()); // not allowed
		*/	
			

		/*
			Executive executive = session.get(Executive.class, 222);
			
			System.out.println("Employee Information");
			System.out.println("Employee Information");
			System.out.println("Employee Id   : " + executive.getEid());
			System.out.println("Employee Name : " + executive.getEname());
			System.out.println("Employee Name : " + executive.getErole());
	    */		

		/*
		
		// Not Works bcoz query is formed
		// select executive0_.EID as eid2_0_0_, executive0_.ENAME as ename3_0_0_, executive0_.EROLE as erole4_0_0_ from EMP1 executive0_ where executive0_.EID=? and executive0_.TYPE='EXECUTIVE'
		//So , no data found to form executive object , it means executive id null .
		 
			Executive executive = session.get(Executive.class, 101);
			
			System.out.println("Employee Information");
			
			System.out.println("Employee Id   : " + executive.getEid());
			System.out.println("Employee Name : " + executive.getEname());
			System.out.println("Employee Name : " + executive.getErole());
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
