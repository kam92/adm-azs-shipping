package com.backend.frete.domain.repository;

import com.backend.frete.domain.Frete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface FreteRepository extends MongoRepository<Frete, String> {

    List<Frete> findAll();

    default List<Frete> findByPropriedadeValue(String value) {
        List<Frete> allFrete = findAll();
        return allFrete.stream()
                .filter(frete -> frete.getPropriedades().containsValue(value))
                .collect(Collectors.toList());
    }

}
