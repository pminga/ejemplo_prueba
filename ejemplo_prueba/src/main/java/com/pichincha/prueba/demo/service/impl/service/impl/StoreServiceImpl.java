package com.pichincha.prueba.demo.service.impl.service.impl;

import com.pichincha.prueba.demo.service.impl.Exception.StoreException;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.prueba.demo.service.impl.dto.StoreDto;
import com.pichincha.prueba.demo.service.impl.entity.Store;
import com.pichincha.prueba.demo.service.impl.repository.StoreRepository;
import com.pichincha.prueba.demo.service.impl.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository; 
	
	@Override
	public ResponseDto saveStore(StoreDto storeDto) throws StoreException {
		
		Store storeBdd = new Store();
		storeBdd.setCategory(storeDto.getCategory());
		storeBdd.setName(storeDto.getName());
		storeBdd.setOwner(storeDto.getOwner());
		try
		{
			Store storeSaved = storeRepository.save(storeBdd);
			return new ResponseDto("Store Saved: "+storeSaved.getId());
		} catch (Exception e)
		{
			throw new StoreException("No se puede guardar datos de la tienda  en la BDD", e);
		}

	}

}
