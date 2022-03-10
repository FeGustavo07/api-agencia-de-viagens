package com.dreamtrip.destinos.gateways.persistence.mysqlImpl.entities;

import com.dreamtrip.destinos.domain.Destino;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_DESTINOS")
@NoArgsConstructor
public class DestinoEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private double preco;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "LINK_IMAGEM")
    private String linkImagem;

    public DestinoEntity(Destino destino) {
        id = destino.getId();
        nome = destino.getNome();
        preco = destino.getPreco();
        descricao = destino.getDescricao();
        linkImagem = destino.getLinkImagem();
    }

    public Destino ConverteParaDomain() {
        return Destino.builder()
                .id(id)
                .nome(nome)
                .preco(preco)
                .descricao(descricao)
                .linkImagem(linkImagem)
                .build();
    }
}
