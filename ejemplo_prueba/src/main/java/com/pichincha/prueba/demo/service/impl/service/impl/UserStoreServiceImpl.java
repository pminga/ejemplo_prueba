package com.pichincha.prueba.demo.service.impl.service.impl;

import com.pichincha.prueba.demo.service.impl.Exception.ProductException;
import com.pichincha.prueba.demo.service.impl.Exception.UserStoreException;
import com.pichincha.prueba.demo.service.impl.dto.ProductDto;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.dto.UserStoreDto;
import com.pichincha.prueba.demo.service.impl.entity.Product;
import com.pichincha.prueba.demo.service.impl.entity.UserStore;
import com.pichincha.prueba.demo.service.impl.repository.ProductRepository;
import com.pichincha.prueba.demo.service.impl.repository.UserStoreRepository;
import com.pichincha.prueba.demo.service.impl.service.UserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserStoreServiceImpl implements UserStoreService {
    @Autowired
    private UserStoreRepository userStoreRepository;

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

      public java.util.Date parseDate(String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public ResponseDto saveUserStore(UserStoreDto userStoreDto) throws UserStoreException {

        UserStore userStoreBdd = new UserStore();
        userStoreBdd.setUserName(userStoreDto.getUserName());
        userStoreBdd.setCreatedDate(userStoreDto.getCreatedDate());
        try
        {
            UserStore userStoreSaved = userStoreRepository.save(userStoreBdd);
            return new ResponseDto("User Store Saved: "+userStoreSaved.getId());
        } catch (Exception e)
        {
            throw new UserStoreException("No se puede guardar datos del usuario en la BDD", e);
        }

    }

}
