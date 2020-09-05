package com.shoppingcart.productcatalogue.repository;

import com.shoppingcart.productcatalogue.entity.Brand;
import com.shoppingcart.productcatalogue.entity.Category;
import com.shoppingcart.productcatalogue.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByBrand(Brand brand);
    List<Product> findByCategory(Category category);
}
