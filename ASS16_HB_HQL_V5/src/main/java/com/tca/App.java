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
