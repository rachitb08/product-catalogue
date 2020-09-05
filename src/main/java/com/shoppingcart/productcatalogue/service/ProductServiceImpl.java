package com.shoppingcart.productcatalogue.service;

import com.shoppingcart.productcatalogue.constants.EnumFilterType;
import com.shoppingcart.productcatalogue.entity.Brand;
import com.shoppingcart.productcatalogue.entity.Category;
import com.shoppingcart.productcatalogue.entity.Product;
import com.shoppingcart.productcatalogue.exception.ProductCatalogueException;
import com.shoppingcart.productcatalogue.repository.BrandRepository;
import com.shoppingcart.productcatalogue.repository.CategoryRepository;
import com.shoppingcart.productcatalogue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> searchProducts(String filterType, String filterValue) {

        EnumFilterType enumFilterType = EnumFilterType.valueOf(filterType.toUpperCase());
        switch (enumFilterType) {
            case BRAND:
                Brand brand = brandRepository.findById(Long.valueOf(filterValue)).orElseThrow(() -> new ProductCatalogueException("Brand not found"));
                return productRepository.findByBrand(brand);
            case CATEGORY:
                Category category = categoryRepository.findById(Long.valueOf(filterValue)).orElseThrow(() -> new ProductCatalogueException("Category not found"));
                return productRepository.findByCategory(category);
            default:
                return Collections.emptyList();
        }

    }

}
