package com.backend.frete.service;
import com.backend.frete.apiimpl.command.FreteCommandServiceImpl;
import com.backend.frete.domain.Frete;
import com.backend.frete.domain.repository.FreteRepository;
import com.backend.frete.dto.FreteDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


class FreteCommandServiceTest {

    @Mock
    private FreteRepository freteRepository;

    @InjectMocks
    private FreteCommandServiceImpl freteCommandService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testPost() {
        FreteDto freteDto = new FreteDto();
        freteDto.setPropriedades(Collections.singletonMap("key", "value"));

        Frete frete = new Frete();
        frete.setPropriedades(freteDto.getPropriedades());

        when(freteRepository.save(any(Frete.class))).thenReturn(frete);

        ResponseEntity<Frete> responseEntity = freteCommandService.post(freteDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(frete.getPropriedades(), responseEntity.getBody().getPropriedades());
    }

    @Test
    void testUpdate() {
        String freteId = "123";
        FreteDto freteDto = new FreteDto();
        freteDto.setPropriedades(Collections.singletonMap("key", "value"));

        Frete existingFrete = new Frete();
        existingFrete.setPropriedades(Collections.singletonMap("existingKey", "existingValue"));

        when(freteRepository.findById(freteId)).thenReturn(Optional.of(existingFrete));
        when(freteRepository.save(any(Frete.class))).thenReturn(existingFrete);

        ResponseEntity<Frete> responseEntity = freteCommandService.update(freteId, freteDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    void testDeleteById() {
        String freteId = "123";

        ResponseEntity<Object> responseEntity = freteCommandService.deleteById(freteId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        Mockito.verify(freteRepository, Mockito.times(1)).deleteById(freteId);
    }
}
