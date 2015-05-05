package com.mobileshopping.service.products.service;

import java.util.ArrayList;
import java.util.List;

import com.mobileshopping.service.products.controller.DAOController;
import com.mobileshopping.service.products.database.HibernateDAOImpl;
import com.mobileshopping.service.products.model.Product;

public class ProductService {

	private static ProductService productService;
	// Map<Long, Product> products = new DatabaseClass().getProducts();

	DAOController daoControler = new DAOController(new HibernateDAOImpl());

	private ProductService() {
		// System.out.println("adding rows");
		// daoControler.addProduct(new Product("A101-01-01", "Peynir",
		// "Tahsildarooglu", "25", "05,04,2015", "15,08,2015",
		// "Tahsildarooglu Peynir", 400));
		// daoControler.addProduct( new Product("A101-01-02", "Yumurta",
		// "Kenkinoglu", "12TL", "01,04,2015", "12,09,2015",
		// "Kenkinoglu Yumurta", 1000));
	}

	public synchronized static ProductService getInstance() {

		if (productService == null) {
			productService = new ProductService();
		}
		return productService;
	}

	public List<Product> getAllProducts() {
		return new ArrayList<Product>(daoControler.getProductList());
	}

	public Product getProduct(String productCode) {
		return daoControler.getProduct(productCode);
	}

	public String addProduct(Product product) {
		return daoControler.addProduct(product);
	}

}
