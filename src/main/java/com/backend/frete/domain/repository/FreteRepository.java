package com.backend.frete.domain.repository;

import com.backend.frete.domain.Frete;
import com.backend.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface FreteRepository extends MongoRepository<Frete, String> {

    List<Frete> findAll();

    default Page<Frete> findByPropriedadesValue(String value, Pageable pageable) {
        List<Frete> allFrete = findAll();
        List<Frete> filteredFrete = allFrete.stream()
                .filter(frete -> frete.getPropriedades().containsValue(value))
                .collect(Collectors.toList());

        return PageUtils.createPage(filteredFrete, pageable);
    }

}
