package com.shawncrahen.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.shawncrahen.application.entity.StationEntity;

public interface StationRepository extends CrudRepository<StationEntity, Long> {
  StationEntity findByStationId(String stationId);
}
