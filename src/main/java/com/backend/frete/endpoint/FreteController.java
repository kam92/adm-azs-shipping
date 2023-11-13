package com.backend.frete.endpoint;

import com.backend.frete.api.command.FreteCommandService;
import com.backend.frete.api.query.FreteQueryService;
import com.backend.frete.domain.Frete;
import com.backend.frete.dto.FreteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frete")
public class FreteController {

    FreteQueryService freteQueryService;
    FreteCommandService freteCommandService;
    @Autowired
    public FreteController(FreteQueryService freteQueryService, FreteCommandService freteCommandService) {
        this.freteQueryService = freteQueryService;
        this.freteCommandService = freteCommandService;

    }

    @PostMapping
    public HttpEntity<Frete> post(@RequestBody FreteDto freteDTO) {
        return freteCommandService.post(freteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Frete> updateFrete(@PathVariable String id, @RequestBody FreteDto freteDTO) {
        return freteCommandService.update(id, freteDTO);
    }

    @GetMapping("/{propriedade}/{page}/{size}")
    public HttpEntity<Page<Frete>> findByPropriedadeValue(@PathVariable String propriedade, @PathVariable int page, @PathVariable int size) {
        return freteQueryService.findByPropriedadeValue(propriedade, page, size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id) {
       return freteCommandService.deleteById(id);
    }

}
