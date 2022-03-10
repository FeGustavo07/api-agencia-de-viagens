package com.dreamtrip.destinos.gateways.controllers.responses;

import com.dreamtrip.destinos.domain.Destino;
import lombok.Data;

@Data
public class DestinoResponse {
    private Long id;
    private String nome;
    private double preco;
    private String descricao;
    private String linkImagem;

    public DestinoResponse(Destino destino) {
        id = destino.getId();
        nome = destino.getNome();
        preco = destino.getPreco();
        descricao = destino.getDescricao();
        linkImagem = destino.getLinkImagem();
    }
}
