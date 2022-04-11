package com.shawncrahen.application.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.ActiveStation;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.repository.StationRepository;

@Service
@Scope("session")
public class StationService {

  private StationRepository repository;
  private ActiveStation activeStation;

  public StationService(StationRepository repository, ActiveStation activeStation) {
    this.repository = repository;
    this.activeStation = activeStation;
  }

  public ActiveStation getActiveStation() {
    return activeStation;
  }

  public void setActiveStation(ActiveStation activeStation) {
    this.activeStation = activeStation;
  }

  public Station getStation() {
    return repository.findByStationId(activeStation.getName());
  }

  public Iterable<Station> getAllStations() {
    return repository.findAll();
  }

  @Override
  public String toString() {
    return "{\n  \"StationService\": {\n    \"repository\":\"" + repository
            + "\", \n    \"activeStation\":\"" + activeStation + "\"\n  }\n}";
  }

}
