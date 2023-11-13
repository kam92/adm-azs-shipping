package com.backend.frete.api.command;

import com.backend.frete.domain.Frete;
import com.backend.frete.dto.FreteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface FreteCommandService {

    /**
     * Método para cadastrar um novo frete.
     * @param freteDTO objeto DTO representando um frete.
     * @return A entidade com o código HTTP e o objeto cadastrado.
     */
    ResponseEntity<Frete> post(FreteDto freteDTO);

    /**
     * Método para atualizar um frete.
     * Pode tanto atualizar valores.
     * @param id id do frete a ser atualizado.
     * @param freteDTO objeto DTO com as propriedades.
     * @return A entidade com o código HTTP e o objeto atualizado.
     */
    ResponseEntity<Frete> update(String id, FreteDto freteDTO);


    /**
     * Método para deletar um frete
     * @param id id do frete a ser removido.
     * @return A entidade com o código HTTP.
     */
    ResponseEntity<Object> deleteById(String id);
}
