package com.nagarro.trainee.advanceJava.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.trainee.advanceJava.model.Product;
import com.nagarro.trainee.advanceJava.util.HibernateUtil;

public class ProductDao {

	// to add product to database
	public static void addProduct(String title, int quantity, int size, String image) {
		Product product = new Product();
		product.setImage(image);
		product.setQuantity(quantity);
		product.setSize(size);
		product.setTitle(title);
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// will return matching product from database
	public static Product getProduct(String title) {
		String t = title.trim();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Product where title = :a");
			q.setParameter("a", t);
			Product product = (Product) q.uniqueResult();

			tx.commit();
			return product;

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("invalid title");
		return null;

	}

	// delete product form database
	public static void deleteProduct(String title) {
		String t = title.trim();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			System.out.println("in delete");
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("delete from Product where title= :a");
			q.setParameter("a", t);
			int r = q.executeUpdate();
			tx.commit();
			if (r > 0) {
				System.out.println("product deleted");
			}

		} catch (Exception e) {
			System.out.println("Product not deleted");
			e.printStackTrace();
		}
	}

	// edit product
	public static void editProduct(String title, int quantity, int size, String image) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("update Product set quantity= :b,size= :c,image= :d " + "where title = :a");
			q.setParameter("a", title);
			q.setParameter("b", quantity);
			q.setParameter("c", size);
			q.setParameter("d", image);

			int r = q.executeUpdate();
			tx.commit();
			if (r > 0) {
				System.out.println("product edited");
			}

		} catch (Exception e) {
			System.out.println("Product not edited");
			e.printStackTrace();
		}

	}
}
