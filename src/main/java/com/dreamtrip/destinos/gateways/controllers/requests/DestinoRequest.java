package com.dreamtrip.destinos.gateways.controllers.requests;

import com.dreamtrip.destinos.domain.Destino;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DestinoRequest {
    private String nome;
    private double preco;
    private String descricao;
    private String linkImagem;

    public Destino converteParaDomain() {
        return Destino.builder()
                .nome(nome)
                .preco(preco)
                .descricao(descricao)
                .linkImagem(linkImagem)
                .build();
    }
}
