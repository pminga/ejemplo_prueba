package com.pichincha.prueba.demo.service.impl;

import com.pichincha.prueba.demo.service.impl.Exception.StoreException;
import com.pichincha.prueba.demo.service.impl.Exception.UserStoreException;
import com.pichincha.prueba.demo.service.impl.dto.ResponseDto;
import com.pichincha.prueba.demo.service.impl.dto.StoreDto;
import com.pichincha.prueba.demo.service.impl.dto.UserStoreDto;
import com.pichincha.prueba.demo.service.impl.entity.Store;
import com.pichincha.prueba.demo.service.impl.entity.UserStore;
import com.pichincha.prueba.demo.service.impl.repository.StoreRepository;
import com.pichincha.prueba.demo.service.impl.repository.UserStoreRepository;
import com.pichincha.prueba.demo.service.impl.service.impl.StoreServiceImpl;
import com.pichincha.prueba.demo.service.impl.service.impl.UserStoreServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;




@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserStoreServiceImplTest {

    @MockBean
    UserStoreRepository userStoreRepository;
    @InjectMocks
    UserStoreServiceImpl userStoreService;

    private UserStoreDto userStoreDto;

    @BeforeEach
    private void initialize() {
        userStoreDto = new UserStoreDto();
        userStoreDto.setUserName("pminga");
        userStoreDto.setCreatedDate(userStoreService.parseDate( "2013-09-29"));
    }

    @Test
    public void givenUserStoreWithoutStock_whenSaveASUserStoreRequest_thenSaveUserStoreInDb() throws UserStoreException {

        Mockito.when(userStoreRepository.save(Mockito.any(UserStore.class)))
                .thenReturn(new UserStore(1L, "mock", null, null));
        ResponseDto responseDto = userStoreService.saveUserStore(userStoreDto);
        Assert.hasText(responseDto.getMessage(), "No se guardó en la BDD");
    }

    @Test()
    public void givenUserStoreWithoutStock_whenSaveASUserStoreRequestAndBddProblems_thenThrowsUserStoreException() {

        Mockito.when(userStoreRepository.save(Mockito.any(UserStore.class)))
                .thenThrow(new RuntimeException("Something wrong with Database"));
        UserStoreException exception = null;
        try {
            userStoreService.saveUserStore(userStoreDto);
        } catch (UserStoreException e) {
            exception = e;
        }
        Assert.notNull(exception, "No se produjo la excepcion esperada UserStoreException");

    }
}
