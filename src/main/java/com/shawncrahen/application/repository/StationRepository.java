package com.shawncrahen.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.shawncrahen.application.entity.Station;

public interface StationRepository extends CrudRepository<Station, Long> {
  Station findByStationId(String stationId);
}
