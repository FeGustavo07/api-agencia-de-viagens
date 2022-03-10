package com.dreamtrip.destinos.usecases;

import com.dreamtrip.destinos.domain.Destino;
import com.dreamtrip.destinos.execeptions.ValidacaoExecption;
import com.dreamtrip.destinos.gateways.persistence.DestinoPersistenceGateway;
import com.dreamtrip.destinos.usecases.validators.ValidadorExcluirDestino;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirDestino {

    private final DestinoPersistenceGateway destinoPersistenceGateway;
    private final ValidadorExcluirDestino validadorExcluirDestino;

    public void executar(Destino destino) {
        val errosDeValidacao = validadorExcluirDestino.validar(destino);

        if (!errosDeValidacao.isEmpty()) {
            throw new ValidacaoExecption(errosDeValidacao);
        }

        destinoPersistenceGateway.excluir(destino);
    }
}
