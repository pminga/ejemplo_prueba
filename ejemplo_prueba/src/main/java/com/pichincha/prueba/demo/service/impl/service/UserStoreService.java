package com.pichincha.prueba.demo.service.impl.service;

import com.pichincha.prueba.demo.service.impl.Exception.StoreException;
import com.pichincha.prueba.demo.service.impl.Exception.UserStoreException;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.dto.StoreDto;
import com.pichincha.prueba.demo.service.impl.dto.UserStoreDto;

public interface UserStoreService {
    ResponseDto saveUserStore(UserStoreDto UserStoreDto) throws UserStoreException;
}
