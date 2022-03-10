package com.dreamtrip.destinos.usecases;

import com.dreamtrip.destinos.domain.Destino;
import com.dreamtrip.destinos.gateways.persistence.DestinoPersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarDestinos {

    private final DestinoPersistenceGateway destinoPersistenceGateway;

    public List<Destino> executar() {
        return destinoPersistenceGateway.listarDestinos();
    }
}
