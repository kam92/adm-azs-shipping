package com.backend.frete.apiimpl.command;

import com.backend.frete.api.command.FreteCommandService;
import com.backend.frete.domain.Frete;
import com.backend.frete.domain.repository.FreteRepository;
import com.backend.frete.dto.FreteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class FreteCommandServiceImpl implements FreteCommandService {

    FreteRepository freteRepository;
    @Autowired
    public FreteCommandServiceImpl(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    @Override
    public ResponseEntity<Frete> post(FreteDto freteDTO) {
        try {
            Frete frete = convertToFrete(freteDTO);
            freteRepository.save(frete);
            return ResponseEntity.status(HttpStatus.CREATED).body(frete);
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.status(500).build();
        }
    }

    private Frete convertToFrete(FreteDto freteDTO) {
        Frete frete = new Frete();
        frete.setPropriedades(freteDTO.getPropriedades());
        return frete;
    }

    @Override
    public ResponseEntity<Frete> update(String id, FreteDto freteDTO) {
        try {
            Frete existingFrete = freteRepository.findById(id)
                    //.orElseThrow(() -> new NoSuchElementException())
                    .orElseThrow(NoSuchElementException::new);

            Map<String, String> updatedPropriedades = freteDTO.getPropriedades();
            existingFrete.getPropriedades().putAll(updatedPropriedades);

            freteRepository.save(existingFrete);

            return ResponseEntity.ok(existingFrete);

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(String id) {
        try {
            freteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.internalServerError().build();
        }
    }
}
