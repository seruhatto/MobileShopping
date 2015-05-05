package com.mobileshopping.service.products.controller;

import java.util.List;

import com.mobileshopping.service.products.interfaces.DAO;
import com.mobileshopping.service.products.model.Product;

public class DAOController {

	private DAO dao;

	public DAOController(DAO dao) {
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	/**
	 * Get Product object via DAO
	 * 
	 * @param id
	 * @return Product
	 */
	public Product getProduct(String productCode) {
		System.out.println(" DAOController:getProduct");
		return dao.getProduct(productCode);
	}

	/**
	 * Get all Product objects via DAO
	 * 
	 * @return List of Product objects
	 */
	public List<Product> getProductList() {
		System.out.println(" DAOController:getProductList");
		return dao.getProductList();
	}

	/**
	 * Add a Product object via DAO
	 * 
	 * @param product
	 * @return primary key of added Product
	 */
	public String addProduct(Product product) {
		return dao.addProduct(product);
	}

	/**
	 * Remove the Product object via DAO
	 * 
	 * @param product
	 * @return primary key of removed Product
	 */
	public String removeProduct(Product product) {
		return dao.removeProduct(product);
	}
}
