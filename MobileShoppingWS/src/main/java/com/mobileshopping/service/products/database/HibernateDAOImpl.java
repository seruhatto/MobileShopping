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
	public Product getProduct(String productCode) {
		try {
			Product product = null;
			session = sf.openSession();
			product = (Product) session.get(Product.class, productCode);
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
	public String addProduct(Product product) {
		try {
			session = sf.openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			return product.getProductCode();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} finally {
			session.close();
		}

		return null;

	}

	@Override
	public String removeProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
