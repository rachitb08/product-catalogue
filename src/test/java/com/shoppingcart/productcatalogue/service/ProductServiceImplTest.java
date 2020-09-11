package com.shoppingcart.productcatalogue.service;

import com.shoppingcart.productcatalogue.exception.ProductCatalogueException;
import com.shoppingcart.productcatalogue.repository.BrandRepository;
import com.shoppingcart.productcatalogue.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

@RunWith(PowerMockRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Mock
    BrandRepository brandRepository;

    @Test(expected = ProductCatalogueException.class)
    public void whenBrandNotFound_thenExceptionIsThrown() {
        Mockito.when(brandRepository.findById(4L)).thenReturn(Optional.empty());
        productService.searchProducts("brand","4");
    }
}