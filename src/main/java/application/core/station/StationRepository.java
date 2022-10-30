package application.core.station;

import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<StationEntity, Long> {
  StationEntity findByStationId(String stationId);
}
