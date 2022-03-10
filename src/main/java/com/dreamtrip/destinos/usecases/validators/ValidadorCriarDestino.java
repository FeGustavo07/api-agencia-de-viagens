package com.dreamtrip.destinos.usecases.validators;

import com.dreamtrip.destinos.domain.Destino;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidadorCriarDestino {

    public List<String> validar(Destino destino) {
        List<String> errosDeValidacao = new ArrayList<>();

        if (destino == null) return List.of("Destino não pode ser nulo");

        if (destino.getId() != null) {
            errosDeValidacao.add("Destino já existe");
        }

        if (!StringUtils.hasText(destino.getNome())) {
            errosDeValidacao.add("Nome não pode ser vazio");
        }

        if (Double.isNaN(destino.getPreco()) || destino.getPreco() <= 0) {
            errosDeValidacao.add("Preço não pode ser vazio");
        }

        if (!StringUtils.hasText(destino.getDescricao())) {
            errosDeValidacao.add("Descrição não pode ser vazia");
        }

        if (!StringUtils.hasText(destino.getLinkImagem())) {
            errosDeValidacao.add("Link não pode ser vazio");
        }

        return errosDeValidacao;
    }
}
