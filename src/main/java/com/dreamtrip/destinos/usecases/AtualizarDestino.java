package com.dreamtrip.destinos.usecases;

import com.dreamtrip.destinos.domain.Destino;
import com.dreamtrip.destinos.execeptions.ValidacaoExecption;
import com.dreamtrip.destinos.gateways.persistence.DestinoPersistenceGateway;
import com.dreamtrip.destinos.usecases.validators.ValidadorAtualizarDestino;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarDestino {

    private final DestinoPersistenceGateway destinoPersistenceGateway;
    private final ValidadorAtualizarDestino validadorAtualizarDestino;

    public Destino executar(Destino destino) {

        val errosDeValidacao = validadorAtualizarDestino.validar(destino);

        if (!errosDeValidacao.isEmpty()) {
            throw new ValidacaoExecption(errosDeValidacao);
        }

        return destinoPersistenceGateway.salvar(destino);
    }
}
