package com.mobileshopping.service.products.database;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mobileshopping.service.products.interfaces.DAO;
import com.mobileshopping.service.products.model.Product;

public class HibernateDAOImpl implements DAO {

	SessionFactory sf = null;
	Session session = null;

	public HibernateDAOImpl() {
		try {
			sf = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getProductList() {
		try {
			session = sf.openSession();
			List<Product> products = session.createCriteria(Product.class)
					.list();
			while (products.size() != 0) {
				return products;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public Product getProduct(long id) {
		try {
			Product product = null;
			session = sf.openSession();
			product = (Product) session.get(Product.class, id);
			return product;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public long addProduct(Product product) {
		try {
			session = sf.openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			return product.getStock();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} finally {
			session.close();
		}

		return 0;

	}

	@Override
	public long removeProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

}
