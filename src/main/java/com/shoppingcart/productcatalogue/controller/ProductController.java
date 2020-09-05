package com.shoppingcart.productcatalogue.controller;

import com.shoppingcart.productcatalogue.entity.Product;
import com.shoppingcart.productcatalogue.exception.ProductCatalogueException;
import com.shoppingcart.productcatalogue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping
	public List<Product> findAll() {
		return productService.getAllProduct();
	}

	@GetMapping("/filter/{filterType}/{filterValue}")
	public List<Product> searchProducts(@PathVariable String filterType,
			@PathVariable String filterValue) {
		List<Product> products = productService.searchProducts(filterType, filterValue);
		if (CollectionUtils.isEmpty(products)) {
			throw new ProductCatalogueException("Product Not Found");
		}
		return products;
	}

}