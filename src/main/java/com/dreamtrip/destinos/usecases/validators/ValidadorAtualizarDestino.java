package com.dreamtrip.destinos.usecases.validators;

import com.dreamtrip.destinos.domain.Destino;
import com.dreamtrip.destinos.gateways.persistence.DestinoPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ValidadorAtualizarDestino {

    private final DestinoPersistenceGateway destinoPersistenceGateway;

    public List<String> validar(Destino destino) {
        List<String> errosDeValidacao = new ArrayList<>();
        boolean destinoExiste = destinoPersistenceGateway.verificaSeExistePorId(destino.getId());

        if (!destinoExiste) {
            errosDeValidacao.add("Destino não existe");
        }

        if (destino.getId() == null) {
            errosDeValidacao.add("Destino sem id");
        }

        return errosDeValidacao;
    }
}
