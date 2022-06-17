package com.pichincha.prueba.demo.service.impl.controllers;

import com.pichincha.prueba.demo.service.impl.Exception.ProductException;
import com.pichincha.prueba.demo.service.impl.Exception.UserStoreException;
import com.pichincha.prueba.demo.service.impl.dto.ProductDto;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.dto.UserStoreDto;
import com.pichincha.prueba.demo.service.impl.service.ProductService;
import com.pichincha.prueba.demo.service.impl.service.UserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userStore")
public class UserStoreController {

    @Autowired
    private UserStoreService userStoreService ;

    @PostMapping("")
    public ResponseEntity<ResponseDto> createUserStore(@RequestBody UserStoreDto userStore) {
        try {
            return new ResponseEntity<>(userStoreService.saveUserStore(userStore), HttpStatus.OK);
        } catch (UserStoreException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }
}
