package com.backend.frete.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Document(collection = "fretes")
@Getter
@Setter
@NoArgsConstructor
public class Frete {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    @Field("propriedade")
    Map<String, String> propriedades;
}
