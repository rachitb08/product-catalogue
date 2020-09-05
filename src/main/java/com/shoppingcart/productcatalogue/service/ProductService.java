package com.shoppingcart.productcatalogue.service;

import com.shoppingcart.productcatalogue.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    List<Product> searchProducts(String filterType,String filterValue);

}
