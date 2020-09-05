package com.shoppingcart.productcatalogue.repository;

import com.shoppingcart.productcatalogue.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
