package com.tca;

import java.util.List;
//
//import javax.persistence.Query;
import org.hibernate.query.Query;
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

			//-------------------------------------------------------------------------------
		/*	
			//SELECT * FROM student;
			
			Query query = session.createQuery("from Student");
			
			List<Student> L = query.list();
			
			for(Student s : L) {
			
				System.out.println( s.getRno()+ " "
				                  + s.getName()+ " " +
				                    s.getPer() + " " +
				                    s.getCity());
			}
		*/
			
	/*	
			// SELECT sname , scity from student;
			
			// jr table madhe 5 column astil and you want to retrive only 1,2,3,4 column then use this approch 
			// but you want retrive all column then go with above approch.
			
			
			//This HQL query fetches only selected columns (rno, name, per, city) from the Student entity.
			//Hibernate will not return full Student objects, but each row as an Object array (Object[]), like:
            //[101, "AAA", 89.0, "Pune"]
             
			Query query = session.createQuery("select name,city from Student");
			
			// Each row is an Object[] containing the selected fields
			 
            List<Object[]> L = query.list();
			
            
            //This loop iterates over every Object[] (i.e., each row).
            //First iteration: ob = [101, "AAA", 89.0, "Pune"]
            //Second iteration: ob = [102, "BBB", 92.0, "Mumbai"]
            //And so on…
             
			for(Object[] ob : L) // ob : [0]:101 , [1]:AAA , [2]:89 , [3]:Pune 
			{
				//This loop goes through each individual element inside a single Object[] (i.e., one row).
                //data represents: 101, then "AAA", then 89.0, then "Pune"
                 
				for(Object data : ob) 
				{
					System.out.print(data.toString() + " ");
				}
				System.out.println();
			}
			
	*/
	/*
			// ORDER BY
			
			Query query = session.createQuery("from Student order by per desc");
			
			List<Student> L = query.list();
			
			for(Student s : L) {
				
				System.out.println( s.getRno()+ " " +
				                    s.getName()+ " " +
				                    s.getPer() + " " +
				                    s.getCity());
			}
	*/
			
			
			// Where Clause
	/*		
			Query query = session.createQuery("from Student where per >= 75");

			List<Student> L = query.list();
			
			for(Student s : L) {
				
				System.out.println( s.getRno()+ " " +
				                    s.getName()+ " " +
				                    s.getPer() + " " +
				                    s.getCity());
			}
	*/
			
			// Aggegrate Function (MIN , MAX , COUNT , SUM , AVG)
			
		/*	
			Query query = session.createQuery("select max(per),min(per),avg(per),sum(per),count(*) from Student");
			
			List<Object[]> L = query.list();
			
			for(Object[] data : L) {
				for(Object ob : data) {
					System.out.print(ob.toString() + " ");
				}
				System.out.println();
			}
			
		*/
		
			/*
			Query query1 = session.createQuery("select max(per) from Student");
			
			List<Long> L1 = query1.list();
			
			System.out.println("Maximum Percentage : " + L1.get(0));
			
			
            Query query2 = session.createQuery("select min(per) from Student");
			
			List<Long> L2 = query2.list();
			
			System.out.println("Minimum Percentage : " + L2.get(0));
			*/
			
			// GROUP BY and HAVING Clause
		/*	
			Query query1 = session.createQuery("select city from Student group by city having count(*) >= 2");
			
			List<Object> L1 = query1.list();
			
			for(Object data : L1) {
				System.out.println(data.toString());
			}
			

			Query query = session.createQuery("select city,count(*) from Student group by city having count(*) >= 2");
			
			List<Object[]> L = query.list();
			
			for(Object[] data : L) {

				for(Object ob : data) {
					System.out.print(ob.toString() + " ");
				}
				System.out.println();

			}
		*/
			
		/*
			// Arthmetic Operation
			Query query = session.createQuery("select per+2 from Student");
			
			List<Double> L = query.list();
			
				for(Double ob : L) {
					System.out.println(ob);
				}
		*/
			
			
		/*	
		  
		   // AND & OR
		  
			Query query = session.createQuery("from Student where per >= 75 and per <= 90 ");
			
			List<Student> L = query.list();
			
			for(Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
			
			// OR
			
			Query query1 = session.createQuery("from Student where city = 'PUNE' or city= 'MUMBAI' ");
			

			List<Student> L1 = query1.list();
			
			for(Student s1 : L1) {
				System.out.println(s1.getRno() + " " + s1.getName() + " " + s1.getPer() + " " + s1.getCity());
			}
		*/	
		
		/*
			// BETWEEN CLAUSE
			 
			Query query = session.createQuery("from Student where per between 70 and 80");
			
			List<Student> L = query.list();
			
			for(Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
			
		*/
			
		/*
			
			// LIKE , NOT LIKE , % , _(under score)
			
			Query query = session.createQuery("from Student where city like 'D%'");

			List<Student> L = query.list();
			
			for(Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
		*/
		
			
		/*
			// IS NOT NULL , IS NULL
			
			Query query = session.createQuery("from Student where name IS NULL");

			List<Student> L = query.list();
			
			for(Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
			

			Query query1 = session.createQuery("from Student where name IS NOT NULL");

			List<Student> L1 = query1.list();
			
			for(Student s1 : L1) {
				System.out.println(s1.getRno() + " " + s1.getName() + " " + s1.getPer() + " " + s1.getCity());
			}
		*/
		
		/*
			// Sub Queries
			
			Query query = session.createQuery("from Student where per = (select max(per) from Student)");

			List<Student> L = query.list();
			
			for(Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
		*/
			
		/*
			// Positional Parameter
			

			Query query = session.createQuery("from Student where per >= ?0 and per <= ?1");
			
			query.setParameter(0, 75.0);
			query.setParameter(1, 90.0);
			
			List<Student> L = query.list();
			
			for(Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
			
		*/
	/*		
			// HQL - Named Parameter

			Query query = session.createQuery("from Student where per >= :abc and per <= :pqr");
			
			query.setParameter("abc", 75.0);
			query.setParameter("pqr", 90.0);
			
			List<Student> L = query.list();
			
			for(Student s : L) {
				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() + " " + s.getCity());
			}
		*/
			
		/*
			// UPDATE
			Query query = session.createQuery("update Student set per = per+5 where city = 'PUNE'");
			
			int count = query.executeUpdate();
			
			System.out.println("No. of records updated : " + count);
        */
			
		/*
			// DELETE
			Query query = session.createQuery("delete from Student where city = 'PUNE'");
			
			int count = query.executeUpdate();
			
			System.out.println("No. of records deleted : " + count);
		*/
			
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
