package com.dreamtrip.destinos.usecases;

import com.dreamtrip.destinos.domain.Destino;
import com.dreamtrip.destinos.execeptions.ValidacaoExecption;
import com.dreamtrip.destinos.gateways.persistence.DestinoPersistenceGateway;
import com.dreamtrip.destinos.usecases.validators.ValidadorCriarDestino;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarDestino {

    private final DestinoPersistenceGateway destinoPersistenceGateway;
    private final ValidadorCriarDestino validadorCriarDestino;

    public Destino executar(Destino destino) {

        val errosDeValidacao = validadorCriarDestino.validar(destino);

        if (!errosDeValidacao.isEmpty()) {
            throw new ValidacaoExecption(errosDeValidacao);
        }

        return destinoPersistenceGateway.salvar(destino);
    }
}
