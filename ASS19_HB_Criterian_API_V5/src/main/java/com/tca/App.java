package com.tca;

import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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

			// ---------------------------Criterion
			// API----------------------------------------------------

			/*
			 * // 1. SELECT * FROM student;
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for(Student s : list) { System.out.println("Roll Number : " + s.getRno());
			 * System.out.println("Name        : " + s.getName());
			 * System.out.println("Percentage  : " + s.getPer());
			 * System.out.println("City        : " + s.getCity());
			 * System.out.println("------------------------------"); }
			 */

			/*
			 * // SELECT * FROM student ORDER BY per DESC;
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * Order order = Order.desc("per");
			 * 
			 * criteria.addOrder(order);
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for(Student s : list) { System.out.println("Roll Number : " + s.getRno());
			 * System.out.println("Name        : " + s.getName());
			 * System.out.println("Percentage  : " + s.getPer());
			 * System.out.println("City        : " + s.getCity());
			 * System.out.println("------------------------------"); }
			 */

			/*
			 * // SELECT * FROM student ORDER BY per ASC;
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * Order order = Order.asc("per");
			 * 
			 * criteria.addOrder(order);
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for(Student s : list) { System.out.println("Roll Number : " + s.getRno());
			 * System.out.println("Name        : " + s.getName());
			 * System.out.println("Percentage  : " + s.getPer());
			 * System.out.println("City        : " + s.getCity());
			 * System.out.println("------------------------------"); }
			 */

			/*
			 * // SELECT * FROM student WHERE per>=75 AND per<=90 ORDER BY per DESC;
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * // Condition Criterion c1 = Restrictions.ge("per", 75.0); Criterion c2 =
			 * Restrictions.le("per", 90.0);
			 * 
			 * Order order = Order.desc("per");
			 * 
			 * criteria.add(c1); criteria.add(c2); criteria.addOrder(order);
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for(Student s : list) { System.out.println("Roll Number : " + s.getRno());
			 * System.out.println("Name        : " + s.getName());
			 * System.out.println("Percentage  : " + s.getPer());
			 * System.out.println("City        : " + s.getCity());
			 * System.out.println("------------------------------"); }
			 */

			/*
			 * // Scalar Query
			 * 
			 * // SELECT name,per FROM student WHERE per>=75 AND per<=90 ORDER BY per DESC;
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * ProjectionList pl = Projections.projectionList();
			 * 
			 * pl.add(Projections.property("name")); pl.add(Projections.property("per"));
			 * 
			 * Criterion c1 = Restrictions.ge("per", 75.0); Criterion c2 =
			 * Restrictions.le("per", 90.0);
			 * 
			 * Order order = Order.desc("per");
			 * 
			 * criteria.setProjection(pl); criteria.add(c1); criteria.add(c2);
			 * criteria.addOrder(order);
			 * 
			 * List<Object[]> list = criteria.list();
			 * 
			 * for(Object[] ob : list) { for(Object data : ob) {
			 * System.out.print(data.toString() + " "); } System.out.println(); }
			 */

			/*
			 * // Scalar Query
			 * 
			 * // SELECT name,city from student
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * ProjectionList pl = Projections.projectionList();
			 * 
			 * pl.add(Projections.property("name")); pl.add(Projections.property("city"));
			 * 
			 * criteria.setProjection(pl);
			 * 
			 * List<Object[]> list = criteria.list();
			 * 
			 * for(Object[] ob : list) { for(Object data : ob) {
			 * System.out.print(data.toString() + " "); } System.out.println(); }
			 * 
			 */

			/*
			 * // SELECT count(*) from student
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * ProjectionList pl = Projections.projectionList();
			 * 
			 * pl.add(Projections.rowCount());
			 * 
			 * criteria.setProjection(pl);
			 * 
			 * Long count = (Long) criteria.uniqueResult();
			 * 
			 * System.out.println("Number of records : " + count);
			 */

			/*
			 * // SELECT max(per) from student
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * ProjectionList pl = Projections.projectionList();
			 * 
			 * pl.add(Projections.max("per"));
			 * 
			 * criteria.setProjection(pl);
			 * 
			 * Double count = (Double) criteria.uniqueResult();
			 * 
			 * System.out.println("Maximum percentage : " + count);
			 * 
			 */

			/*
			 * // SELECT sum(per) from student
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * ProjectionList pl = Projections.projectionList();
			 * 
			 * pl.add(Projections.sum("per"));
			 * 
			 * criteria.setProjection(pl);
			 * 
			 * Double count = (Double) criteria.uniqueResult();
			 * 
			 * System.out.println("Total Sum : " + count);
			 */

			/*
			 * // LIKE , % , _
			 * 
			 * // select * from student where city LIKE 'P%';
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * criteria.add(Restrictions.like("city", "P%"));
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for (Student s : list) { System.out.println("Roll Number : " + s.getRno());
			 * System.out.println("Name        : " + s.getName());
			 * System.out.println("Percentage  : " + s.getPer());
			 * System.out.println("City        : " + s.getCity());
			 * System.out.println("------------------------------"); }
			 */

			/*
			 * // select * from student where city LIKE '%E';
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * criteria.add(Restrictions.like("city", "%E"));
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for (Student s : list) { System.out.println("Roll Number : " + s.getRno());
			 * System.out.println("Name        : " + s.getName());
			 * System.out.println("Percentage  : " + s.getPer());
			 * System.out.println("City        : " + s.getCity());
			 * System.out.println("------------------------------"); }
			 */

			/*
			 * // select * from student where city LIKE '%AN%';
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * criteria.add(Restrictions.like("city", "%AN%"));
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for (Student s : list) { System.out.println("Roll Number : " + s.getRno());
			 * System.out.println("Name        : " + s.getName());
			 * System.out.println("Percentage  : " + s.getPer());
			 * System.out.println("City        : " + s.getCity());
			 * System.out.println("------------------------------"); }
			 */

			/*
			 * // select * from student where city LIKE '_____';
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * criteria.add(Restrictions.like("city", "_____"));
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for (Student s : list) { System.out.println("Roll Number : " + s.getRno());
			 * System.out.println("Name        : " + s.getName());
			 * System.out.println("Percentage  : " + s.getPer());
			 * System.out.println("City        : " + s.getCity());
			 * System.out.println("------------------------------"); }
			 */

			/*
			 * // GROUP BY
			 * 
			 * // SELECT city ,count(*) FROM student GROUP BY city ;
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * ProjectionList pl = Projections.projectionList();
			 * 
			 * pl.add(Projections.groupProperty("city")); pl.add(Projections.rowCount());
			 * 
			 * criteria.setProjection(pl);
			 * 
			 * List<Object[]> list = criteria.list();
			 * 
			 * for (Object[] ob : list) { for (Object data : ob) {
			 * 
			 * System.out.print(data.toString() + " "); } System.out.println(); }
			 */

			/*
			 * // GROUP BY
			 * 
			 * // SELECT city ,count(*) FROM student GROUP BY city HAVING count(*) >= 2;
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * ProjectionList pl = Projections.projectionList();
			 * 
			 * pl.add(Projections.groupProperty("city")); pl.add(Projections.rowCount());
			 * 
			 * criteria.setProjection(pl);
			 * 
			 * List<Object[]> list = criteria.list(); // L --> [ [PUNE,2] , [MUMBAI,2] ]
			 * 
			 * for (Object[] ob : list) // [PUNE,2] { Long count = (Long) ob[1]; if(count >
			 * 1) { System.out.println("City : " + ob[0] + " ----> No. Of Student : " +
			 * count); }
			 * 
			 * }
			 * 
			 */

			/*
			 * // UPDATE
			 * 
			 * // update student set sper = 99 where srno = 108;
			 * 
			 * Criteria criteria = session.createCriteria(Student.class);
			 * 
			 * criteria.add(Restrictions.eq("rno",108));
			 * 
			 * List<Student> list = criteria.list();
			 * 
			 * for(Student s : list) {
			 * 
			 * s.setPer(55.0); // we can use for update instead of session.update bcoz
			 * update method internally use setter method //session.update(s); }
			 */

			// DELETE ---> delete from student where rno = 108;
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("rno", 107));

			List<Student> list = criteria.list();

			for (Student s : list) {
				session.delete(s); // which removes it from the database, but not from the Java list.
			}

			System.out.println("No. of deleted record : " + list.size());

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
