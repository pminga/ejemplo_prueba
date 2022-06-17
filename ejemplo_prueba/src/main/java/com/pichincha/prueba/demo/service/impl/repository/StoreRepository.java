package com.pichincha.prueba.demo.service.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.prueba.demo.service.impl.entity.Store;

public interface StoreRepository extends JpaRepository<Store,Long > {

}
