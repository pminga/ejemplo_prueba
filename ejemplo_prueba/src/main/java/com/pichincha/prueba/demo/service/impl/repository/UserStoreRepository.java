package com.pichincha.prueba.demo.service.impl.repository;

import com.pichincha.prueba.demo.service.impl.entity.Product;
import com.pichincha.prueba.demo.service.impl.entity.UserStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoreRepository extends JpaRepository<UserStore,Long > {
}
