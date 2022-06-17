package com.pichincha.prueba.demo.service.impl.service.impl;

import com.pichincha.prueba.demo.service.impl.Exception.ProductException;
import com.pichincha.prueba.demo.service.impl.Exception.StoreException;
import com.pichincha.prueba.demo.service.impl.dto.ProductDto;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.dto.StoreDto;
import com.pichincha.prueba.demo.service.impl.entity.Product;
import com.pichincha.prueba.demo.service.impl.entity.Store;
import com.pichincha.prueba.demo.service.impl.repository.ProductRepository;
import com.pichincha.prueba.demo.service.impl.repository.StoreRepository;
import com.pichincha.prueba.demo.service.impl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseDto saveProduct(ProductDto productDto) throws ProductException {

        Product productBdd = new Product();
        productBdd.setName(productDto.getName());
        productBdd.setPrice(productDto.getPrice());
        try
        {
            Product productSaved = productRepository.save(productBdd);
            return new ResponseDto("Store Saved: "+productSaved.getId());
        } catch (Exception e)
        {
            throw new ProductException("No se puede guardar datos del producto en la BDD", e);
        }

    }
}
