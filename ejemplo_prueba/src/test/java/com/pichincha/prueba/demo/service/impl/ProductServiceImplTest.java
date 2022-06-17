package com.pichincha.prueba.demo.service.impl;

import com.pichincha.prueba.demo.service.impl.Exception.ProductException;
import com.pichincha.prueba.demo.service.impl.dto.ProductDto;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.entity.Product;
import com.pichincha.prueba.demo.service.impl.repository.ProductRepository;
import com.pichincha.prueba.demo.service.impl.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ProductServiceImplTest {
    @MockBean
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productService;

    private ProductDto productDto;

    @BeforeEach
    private void initialize() {
        productDto = new ProductDto();
        productDto.setName ("Fideos");
        productDto.setPrice (10.2);
    }

    @Test
    public void givenProductWithoutStock_whenSaveASProductRequest_thenSaveProductInDb() throws ProductException {

        Mockito.when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(new Product(1L, "mock", null,null));
        ResponseDto responseDto = productService.saveProduct(productDto);
        Assert.hasText(responseDto.getMessage(), "No se guardó en la BDD");
    }

    @Test()
    public void givenProductWithoutStock_whenSaveASProductRequestAndBddProblems_thenThrowsProductException() {

        Mockito.when(productRepository.save(Mockito.any(Product.class)))
                .thenThrow(new RuntimeException("Something wrong with Database"));
        ProductException exception = null;
        try {
            productService.saveProduct(productDto);
        } catch (ProductException e) {
            exception = e;
        }
        Assert.notNull(exception, "No se produjo la excepcion esperada StoreException");

    }
}
