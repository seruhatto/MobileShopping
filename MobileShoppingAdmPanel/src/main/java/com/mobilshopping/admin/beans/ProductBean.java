package com.mobilshopping.admin.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.google.gson.Gson;
import com.mobilshopping.admin.model.Product;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

@ManagedBean
@SessionScoped
public class ProductBean {

	public static final String ENDPOINT = "http://217.78.109.129:8080/MobileShoppingWS/webapi";
	Gson gson = new Gson();

	private boolean productResult;

	private Product[] productList;

	private String productCode;
	private String productName;
	private String manufacturer;
	private String cost;
	private String productionDate;
	private String expireDate;
	private String productDetail;
	private int stock;

	public void addButtonAction(ActionEvent actionEvent) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(ENDPOINT + "/products");

			Product product = new Product(getProductCode(), getProductName(),
					getManufacturer(), getCost(), getProductionDate(),
					getExpireDate(), getProductDetail(), getStock());
			// convert java object to JSON format and returned as JSON formatted
			// string
			String jsonProduct = gson.toJson(product);

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, jsonProduct);

			if (response.getStatus() != 201) {
				setProductResult(false);
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			} else {
				setProductResult(true);
				System.out.println("Output from Server .... \n");
				String output = response.getEntity(String.class);
				System.out.println(output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getButtonAction(ActionEvent actionEvent) {
		System.out.println("productGetted calisti");
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(ENDPOINT + "/products/"
					+ getProductCode());

			ClientResponse response = webResource.type("application/json").get(
					ClientResponse.class);

			if (response.getStatus() != 200) {
				setProductResult(false);
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			} else {
				setProductResult(true);
				String entity = response.getEntity(String.class);
				System.out.println("Response is " + entity);
				Product product = gson.fromJson(entity, Product.class);

				setProductName(product.getProductName());
				setProductCode(product.getProductCode());
				setCost(product.getCost());
				setManufacturer(product.getManufacturer());
				setProductionDate(product.getProductionDate());
				setExpireDate(product.getExpireDate());
				setProductDetail(product.getProductDetail());
				setStock(product.getStock());
			}
		} catch (UniformInterfaceException e) {
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		}
	}

	public void getAllProductButtonAction(ActionEvent actionEvent) {
		System.out.println("productGetted calisti");
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(ENDPOINT + "/products");

			ClientResponse response = webResource.type("application/json").get(
					ClientResponse.class);

			if (response.getStatus() != 200) {
				setProductResult(false);
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			} else {
				setProductResult(true);
				String entity = response.getEntity(String.class);
				System.out.println("Response is " + entity);
				productList = gson.fromJson(entity, Product[].class);
			}
		} catch (UniformInterfaceException e) {
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		}
	}

	public Product[] getProductList() {
		return productList;
	}

	public void setProductList(Product[] productList) {
		this.productList = productList;
	}

	public boolean isProductResult() {
		return productResult;
	}

	public void setProductResult(boolean productResult) {
		this.productResult = productResult;
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

}