package com.dreamtrip.destinos.gateways.persistence.mysqlImpl;

import com.dreamtrip.destinos.domain.Destino;
import com.dreamtrip.destinos.gateways.persistence.DestinoPersistenceGateway;
import com.dreamtrip.destinos.gateways.persistence.mysqlImpl.entities.DestinoEntity;
import com.dreamtrip.destinos.gateways.persistence.mysqlImpl.repositories.DestinoMySqlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DestinoMySqlImpl implements DestinoPersistenceGateway {

    private final DestinoMySqlRepository destinoMySqlRepository;

    @Override
    public Destino salvar(Destino destino) {
        DestinoEntity destinoEntity = destinoMySqlRepository.save(new DestinoEntity(destino));
        return destinoEntity.ConverteParaDomain();
    }

    @Override
    public void excluir(Destino destino) {
        destinoMySqlRepository.deleteById(destino.getId());
    }

    @Override
    public List<Destino> listarDestinos() {
        return destinoMySqlRepository.findAll().stream().map(DestinoEntity::ConverteParaDomain).collect(Collectors.toList());
    }

    @Override
    public boolean verificaSeExistePorId(Long id) {
        return destinoMySqlRepository.existsById(id);
    }
}
