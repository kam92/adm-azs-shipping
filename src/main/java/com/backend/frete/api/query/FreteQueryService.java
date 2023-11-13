package com.backend.frete.api.query;

import com.backend.frete.domain.Frete;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FreteQueryService {
    public HttpEntity<List<Frete>> findByPropriedadeValue(String propriedade);
}
