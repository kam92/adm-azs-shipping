package com.backend.frete.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
public class FreteDto {

    @Setter(AccessLevel.NONE)
    String id;

    Map<String, String> propriedades;

}
