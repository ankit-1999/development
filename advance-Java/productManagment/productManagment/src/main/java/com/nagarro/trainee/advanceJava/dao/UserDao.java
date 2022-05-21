package com.nagarro.trainee.advanceJava.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.trainee.advanceJava.model.User;
import com.nagarro.trainee.advanceJava.util.HibernateUtil;

public class UserDao {

	// validate user while login
	public static boolean validateUser(String userName, String password) {
		boolean check = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from User where UserName= :a and password= :b ");
			q.setParameter("a", userName);
			q.setParameter("b", password);
			User user = (User) q.uniqueResult();
			if (user != null && user.getPassword().equals(password)) {
				check = true;
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	public static String getPassword(String username) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from User where UserName= :a");
			q.setParameter("a", username);
			User user = (User) q.uniqueResult();
			tx.commit();
			return user.getPassword();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("invalid username");
		return null;
	}
}
