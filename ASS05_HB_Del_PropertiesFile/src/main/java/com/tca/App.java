package com.tca;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction txn = null;
        
        try {
        	
        	// Approach 1 = By default properties file (hibernate.properties)
        	/**
        	configuration = new Configuration();  	     	
            configuration.addResource("Student.hbm.xml");
        	*/
        	
        	//--------------------------------------------------------------------------
        	
        	// Approach 2 = By using User define Properties File (tca.properties)
        	configuration = new Configuration();
        	FileInputStream fis = new FileInputStream("src/main/resources/tca.properties");
        	
        	Properties prop = new Properties();
        	prop.load(fis);
        	configuration.setProperties(prop);
            configuration.addResource("Student.hbm.xml");

            //------------------------------------------------------
        	
        	sf = configuration.buildSessionFactory();
        	session = sf.openSession();
        	txn = session.beginTransaction();
        	
        	Student student = new Student();
        	student.setRno(111);
        	student.setName("Saurav");
        	student.setPer(75.5);
        	
        	session.save(student);
        	
        	txn.commit();
        	System.out.println("Successfully !!!");
        	
        }catch(Exception e) {
        	e.printStackTrace();
        	txn.rollback();
        }
        finally  
        {
        	session.close();
        	sf.close();
        }
    }
}
