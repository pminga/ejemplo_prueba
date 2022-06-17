package com.pichincha.prueba.demo.service.impl.controllers;

import com.pichincha.prueba.demo.service.impl.Exception.ProductException;
import com.pichincha.prueba.demo.service.impl.Exception.StoreException;
import com.pichincha.prueba.demo.service.impl.dto.ProductDto;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.dto.StoreDto;
import com.pichincha.prueba.demo.service.impl.service.ProductService;
import com.pichincha.prueba.demo.service.impl.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService ;

    @PostMapping("")
    public ResponseEntity<ResponseDto> createProduct(@RequestBody ProductDto product) {
        try {
            return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

}
