package com.shawncrahen.application.service;

import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.ActiveStation;
import com.shawncrahen.application.entity.Station;

@Service
public class StationService {

  private ActiveStation activeStation;
  private Station station;

  private StationService(ActiveStation activeStation, Station station) {
    this.activeStation = activeStation;
    this.station = station;
  }

  public ActiveStation getActiveStation() {
    return activeStation;
  }

  public void setActiveStation(ActiveStation activeStation) {
    this.activeStation = activeStation;
  }

  public Station getStation() {
    return station;
  }

  public void setStation(Station station) {
    this.station = station;
  }

  @Override
  public String toString() {
    return "{\n  \"StationService\": {\n    \"activeStation\":\"" + activeStation
            + "\", \n    \"station\":\"" + station + "\"\n  }\n}";
  }

}
