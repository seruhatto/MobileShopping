package com.mobileshopping.mobile.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

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
		return "\n Urun kodu: " + productCode + "\n Urun: " + productName
				+ "\n Uretici: " + manufacturer + "\n Uretim tarihi: "
				+ productionDate + "\n Son kullanma tarihi: " + expireDate
				+ "\n Urun detayi: " + productDetail + "\n Fiyat: " + cost;
	}

}
