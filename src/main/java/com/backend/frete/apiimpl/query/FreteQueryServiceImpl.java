package com.backend.frete.apiimpl.query;

import com.backend.frete.api.query.FreteQueryService;
import com.backend.frete.domain.Frete;
import com.backend.frete.domain.repository.FreteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class FreteQueryServiceImpl implements FreteQueryService {

    FreteRepository freteRepository;

    @Autowired
    public FreteQueryServiceImpl(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }
    @Override
    public HttpEntity<List<Frete>> findByPropriedadeValue(String propriedade) {
        try {
            List<Frete> freteList = freteRepository.findByPropriedadeValue(propriedade);
            return ResponseEntity.status(HttpStatus.OK).body(freteList);
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.internalServerError().build();
        }
    }
}
