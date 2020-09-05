package com.shoppingcart.productcatalogue.repository;

import com.shoppingcart.productcatalogue.entity.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}
