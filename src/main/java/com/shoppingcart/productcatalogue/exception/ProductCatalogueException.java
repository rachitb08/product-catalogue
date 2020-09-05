package com.shoppingcart.productcatalogue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductCatalogueException extends RuntimeException {

	public ProductCatalogueException(String message) {
		super(message);
	}
}
