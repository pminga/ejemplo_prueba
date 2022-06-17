package com.pichincha.prueba.demo.service.impl.service;

import com.pichincha.prueba.demo.service.impl.Exception.ProductException;
import com.pichincha.prueba.demo.service.impl.Exception.StoreException;
import com.pichincha.prueba.demo.service.impl.dto.ProductDto;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.dto.StoreDto;
import org.springframework.stereotype.Service;


public interface ProductService {
    ResponseDto saveProduct(ProductDto productDto) throws ProductException;
}
