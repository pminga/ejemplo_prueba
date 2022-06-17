package com.pichincha.prueba.demo.service.impl.service;

import com.pichincha.prueba.demo.service.impl.Exception.StoreException;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.dto.StoreDto;

public interface StoreService {

	ResponseDto saveStore(StoreDto storeDto) throws StoreException;
}
