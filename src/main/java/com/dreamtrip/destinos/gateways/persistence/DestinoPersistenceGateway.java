package com.dreamtrip.destinos.gateways.persistence;

import com.dreamtrip.destinos.domain.Destino;

import java.util.List;

public interface DestinoPersistenceGateway {

    Destino salvar(Destino destino);

    void excluir(Destino destino);

    List<Destino> listarDestinos();

    boolean verificaSeExistePorId(Long id);
}
