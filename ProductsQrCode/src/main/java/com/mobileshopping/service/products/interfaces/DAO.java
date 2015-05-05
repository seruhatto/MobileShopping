
package com.mobileshopping.service.products.interfaces;

import java.util.List;

import com.mobileshopping.service.products.model.Product;

public interface DAO {

   /**
    * Is used to get all Product data from database
    * @return List Product
    */
   List<Product> getProductList();

   /**
    * Is used to get specific product form database
    * 
    * @param id: Product id
    * @return Product
    */
   Product getProduct(long id);

   /**
    * Is used to add a Product to database
    * 
    * @param product
    * @return the added Product id
    */
   long addProduct(Product product);
   
   /**
    * Is used to remove the Product from database
    * 
    * @param product
    * @return the removed Product id
    */
   long removeProduct(Product product);
}
