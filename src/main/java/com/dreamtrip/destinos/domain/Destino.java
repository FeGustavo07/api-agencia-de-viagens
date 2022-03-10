package com.dreamtrip.destinos.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Destino {
    private Long id;
    private String nome;
    private double preco;
    private String descricao;
    private String linkImagem;
}
