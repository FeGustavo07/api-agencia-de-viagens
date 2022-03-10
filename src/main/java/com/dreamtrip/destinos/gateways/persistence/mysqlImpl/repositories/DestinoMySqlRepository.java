package com.dreamtrip.destinos.gateways.persistence.mysqlImpl.repositories;

import com.dreamtrip.destinos.gateways.persistence.mysqlImpl.entities.DestinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinoMySqlRepository extends JpaRepository<DestinoEntity, Long> {
}
