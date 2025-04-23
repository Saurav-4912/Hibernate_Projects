package com.tca;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
//import org.hibernate.Query;
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

			//---------------------NATIVE SQL-----------------------------------------------
	/*	 
			// Entity SQL Query
			
			SQLQuery sqlQuery = session.createSQLQuery("select * from student");
			
			sqlQuery.addEntity(Student.class);
			
			List<Student> list = sqlQuery.list();
			
			for(Student s : list) {
				System.out.println("Roll Number : " + s.getRno());
				System.out.println("Name        : " + s.getName());
				System.out.println("Percentage  : " + s.getPer());
				System.out.println("City        : " + s.getCity());
				System.out.println("------------------------------");
			}
	*/		
			
	/*
			// Entity SQL Query with parameter Positional
			
						SQLQuery sqlQuery = session.createSQLQuery("select * from student where sper>= ?0");
						
						sqlQuery.addEntity(Student.class);
						sqlQuery.setParameter(0,70);
						
						List<Student> list = sqlQuery.list();
						
						for(Student s : list) {
							System.out.println("Roll Number : " + s.getRno());
							System.out.println("Name        : " + s.getName());
							System.out.println("Percentage  : " + s.getPer());
							System.out.println("City        : " + s.getCity());
							System.out.println("------------------------------");
						}
		*/
			
		/*
			
			// Entity SQL Query with named parameter
			
						SQLQuery sqlQuery = session.createSQLQuery("select * from student where sper>= :abc");
						sqlQuery.addEntity(Student.class);
						
						sqlQuery.setParameter("abc", 70);
						
						List<Student> list = sqlQuery.list();
						
						for(Student s : list) {
							System.out.println("Roll Number : " + s.getRno());
							System.out.println("Name        : " + s.getName());
							System.out.println("Percentage  : " + s.getPer());
							System.out.println("City        : " + s.getCity());
							System.out.println("------------------------------");
						}
		*/
			
		/*	
			// Scalar SQL Query : if you interested in particular column
			
						SQLQuery sqlQuery = session.createSQLQuery("select srno,sname,scity,sper from student");
						
						sqlQuery.addEntity(Student.class);
						
						List<Student> list = sqlQuery.list();
						
						for(Student s : list) {
							System.out.print(s.getRno() + " ");
							System.out.print(s.getCity() + " ");
							System.out.print(s.getName() + " ");
							System.out.print(s.getPer() + " ");
							System.out.println();
							
						}
		*/
		
		/*
			// INSERT
			
			SQLQuery sqlQuery = session.createSQLQuery("insert into student values(?0,?1,?2,?3)");
			
			sqlQuery.addEntity(Student.class);
			
			sqlQuery.setParameter(0, 111);
			sqlQuery.setParameter(1, "ZZZ");
			sqlQuery.setParameter(2, 78.0);
			sqlQuery.setParameter(3, "PALVE");
			
			int rowCount = sqlQuery.executeUpdate();
			
			System.out.println("No. of rows affected : " + rowCount);
			
		*/	
			
		/*	
			// INSERT Multiple Record
			
			SQLQuery sqlQuery = session.createSQLQuery("insert into student values(?0,?1,?2,?3)");
			
			sqlQuery.addEntity(Student.class);
			
			 // List of students to insert
    
   
			List<Object[]> students = Arrays.asList(        
					new Object[]{112, "ZZZ", 78.0, "PALVE"},        
					new Object[]{113, "AAA", 85.5, "SHARMA"},        
					new Object[]{114, "BBB", 90.0, "KUMAR"}    
					);

   
			for (Object[] s : students) {        
				sqlQuery.setParameter(0, s[0]);        
				sqlQuery.setParameter(1, s[1]);        
				sqlQuery.setParameter(2, s[2]);       
				sqlQuery.setParameter(3, s[3]);
        
				int rowCount = sqlQuery.executeUpdate();
				System.out.println("No. of rows affected : " + rowCount);
    
			}
			
			
		*/	
			
		/*	
			// UPDATE 
			
			SQLQuery sqlQuery = session.createSQLQuery("update student set scity = ?0 where srno = ?1");
			
			sqlQuery.addEntity(Student.class);
			
			sqlQuery.setParameter(0, "GOA");
			sqlQuery.setParameter(1, 111);
			
			int rowCount = sqlQuery.executeUpdate();
			
			System.out.println("No. of rows affected : " + rowCount);
		*/	
			
		/*
			SQLQuery sqlQuery = session.createSQLQuery("update student set scity = ?0 where scity = ?1");
						
			sqlQuery.addEntity(Student.class);
						
			sqlQuery.setParameter(0, "pune");
			sqlQuery.setParameter(1, "PUNE");
						
			int rowCount = sqlQuery.executeUpdate();
						
			System.out.println("No. of rows affected : " + rowCount);
		*/
			
		/*
			// DELETE
			
			SQLQuery sqlQuery = session.createSQLQuery("delete from student where scity = ?0");
			
			sqlQuery.addEntity(Student.class);
						
			sqlQuery.setParameter(0, "GOA");
			
						
			int rowCount = sqlQuery.executeUpdate();
						
			System.out.println("No. of rows affected : " + rowCount);
		*/
		
	
			// DROP TABLE	

			SQLQuery sqlQuery = session.createSQLQuery("drop table student");
			
			sqlQuery.addEntity(Student.class);
			
			int rowCount = sqlQuery.executeUpdate();
						
	
			
			
			
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
