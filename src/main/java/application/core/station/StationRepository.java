package application.core.station;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends CrudRepository<StationEntity, Long> {
    StationEntity findByStationId(String stationId);
}
