package com.mobileshopping.service.products.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mobileshopping.service.products.model.Product;
import com.mobileshopping.service.products.service.ProductService;

@Path("/products")
public class ProductResource {

	public ProductResource() {
		System.out.println("hit to resource constructor");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
		System.out.println("Hit here");
		return ProductService.getInstance().getAllProducts();
	}

	@GET
	@Path("{productCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("productCode") String productCode) {
		System.out.println("hit to ProductResource:getProduct" + productCode);
		return ProductService.getInstance().getProduct(productCode);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProduct(Product product) {

		String result = null;
		if (product != null) {
			System.out.println("At server " + product.toString());
			// Add Product to db
			String resp = ProductService.getInstance().addProduct(product);
			if (resp != null) {
				result = "Prodcut saved : " + product;
				return Response.status(201).entity(result).build();
			}
		}
		result = "Internal Error.";
		return Response.status(500).entity(result).build();

	}
}
