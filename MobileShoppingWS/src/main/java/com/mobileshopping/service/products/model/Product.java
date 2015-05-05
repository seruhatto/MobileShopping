package com.mobileshopping.service.products.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private String productCode;
	private String productName;
	private String manufacturer;
	private String cost;
	private String productionDate;
	private String expireDate;
	private String productDetail;
	private int stock;

	public Product() {
	}

	public Product(String productCode, String productName, String manufacturer,
			String cost, String productionDate, String expireDate,
			String productDetail, int stock) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.cost = cost;
		this.productionDate = productionDate;
		this.expireDate = expireDate;
		this.productDetail = productDetail;
		this.stock = stock;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName="
				+ productName + ", manufacturer=" + manufacturer + ", cost="
				+ cost + ", productionDate=" + productionDate + ", expireDate="
				+ expireDate + ", productDetail=" + productDetail + ", stock="
				+ stock + "]";
	}
}
