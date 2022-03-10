package com.dreamtrip.destinos.usecases.validators;

import com.dreamtrip.destinos.domain.Destino;
import com.dreamtrip.destinos.gateways.persistence.DestinoPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ValidadorExcluirDestino {

    private final DestinoPersistenceGateway destinoPersistenceGateway;

    public List<String> validar(Destino destino) {

        boolean destinoExiste = destinoPersistenceGateway.verificaSeExistePorId(destino.getId());
        List<String> errosDeValidacao = new ArrayList<>();

        if (destino.getId() == null) {
            errosDeValidacao.add("Destino sem id");
        }

        if (!destinoExiste) {
            errosDeValidacao.add("Destino não existe");
        }

        return errosDeValidacao;
    }
}
