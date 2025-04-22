package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Account;

public class App {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();

		Session session = null;
		Transaction txn = null;

		Integer senderAcNo = 101;
		Integer receiverAcNo = 102;
		Double amount = 5000.0;

		try {
			session = sf.openSession();

			Account sob = session.get(Account.class, senderAcNo);

			if (sob == null) {
				System.out.println("Invalid sender account number : " + senderAcNo);
				return;
			}

			if (amount >= sob.getBalance()) {
				System.out.println("Insufficient balance in sender account number : " + senderAcNo);
				return;
			}

			sob.setBalance(sob.getBalance() - amount);

			Account rob = session.get(Account.class, receiverAcNo);

			if (rob == null) {
				System.out.println("Invalid sender account number : " + receiverAcNo);
				return;
			}

			rob.setBalance(rob.getBalance() + amount);

			txn = session.beginTransaction();
			session.update(sob);
			session.update(rob);

			txn.commit();
			System.out.println("Money Transfer Success");

		} catch (Exception e) {

			txn.rollback();
			e.printStackTrace();
			System.out.println("Money Transfer Failed");
		} finally {
			session.close();
			sf.close();
		}

	}
}
