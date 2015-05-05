
package com.mobileshopping.mobile.qrcode;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import com.mobileshopping.mobile.model.Product;


public interface ProductAPI {

   @GET("/products/{productCode}")
   public void getProduct(@Path("productCode") String productCode, Callback<Product> response);
   
   @GET("/products")
   public void getAllProducts(Callback<List<Product>> response);

}
