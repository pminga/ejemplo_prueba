package com.pichincha.prueba.demo.service.impl.repository;

import com.pichincha.prueba.demo.service.impl.entity.Product;
import com.pichincha.prueba.demo.service.impl.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long > {
}
