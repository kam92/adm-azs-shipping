package com.backend.frete.service;

import com.backend.frete.apiimpl.query.FreteQueryServiceImpl;
import com.backend.frete.domain.Frete;
import com.backend.frete.domain.repository.FreteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class FreteQueryServiceTest {

    @Mock
    private FreteRepository freteRepository;

    @InjectMocks
    private FreteQueryServiceImpl freteQueryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByPropriedadeValue() {
        String propriedadeValue = "someValue";
        int page = 0;
        int size = 10;

        Page<Frete> expectedPage = new PageImpl<>(Collections.emptyList());

        when(freteRepository.findByPropriedadesValue(eq(propriedadeValue), any())).thenReturn(expectedPage);

        HttpEntity<Page<Frete>> responseEntity = freteQueryService.findByPropriedadeValue(propriedadeValue, page, size);

        assertEquals(expectedPage, responseEntity.getBody());
    }
}
