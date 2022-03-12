package com.shawncrahen.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stations")
public class Station {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "station_id")
  private String stationId;

  @Column(name = "station_name")
  private String stationName;

  @Column(name = "waves_source_id")
  private String waveSourceId;

  @Column(name = "waves_source_name")
  private String waveSourceName;

  @Column(name = "waves_source_id_2")
  private String waveSourceId2 = null;

  @Column(name = "waves_source_name_2")
  private String waveSourceName2 = null;

  @Column(name = "wind_source_id")
  private String windSourceId;

  @Column(name = "wind_source_name")
  private String windSourceName;

  @Column(name = "weather_source_id")
  private String weatherSourceId;

  @Column(name = "city")
  private String city;

  @Column(name = "tide_source_id")
  private String tideSourceId;

  @Column(name = "tide_source_name")
  private String tideSourceName;

  @Column(name = "current_source_id")
  private String currentSourceId;

  @Column(name = "current_source_name")
  private String currentSourceName;

  @Column(name = "radar_source")
  private String radarSource;

  @Column(name = "time_zone")
  private String timeZone;

  private Station() {}

  public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getWaveSourceId() {
    return waveSourceId;
  }

  public void setWaveSourceId(String waveSourceId) {
    this.waveSourceId = waveSourceId;
  }

  public String getWaveSourceName() {
    return waveSourceName;
  }

  public void setWaveSourceName(String waveSourceName) {
    this.waveSourceName = waveSourceName;
  }

  public String getWaveSourceId2() {
    return waveSourceId2;
  }

  public void setWaveSourceId2(String waveSourceId2) {
    this.waveSourceId2 = waveSourceId2;
  }

  public String getWaveSourceName2() {
    return waveSourceName2;
  }

  public void setWaveSourceName2(String waveSourceName2) {
    this.waveSourceName2 = waveSourceName2;
  }

  public String getWindSourceId() {
    return windSourceId;
  }

  public void setWindSourceId(String windSourceId) {
    this.windSourceId = windSourceId;
  }

  public String getWindSourceName() {
    return windSourceName;
  }

  public void setWindSourceName(String windSourceName) {
    this.windSourceName = windSourceName;
  }

  public String getWeatherSourceId() {
    return weatherSourceId;
  }

  public void setWeatherSourceId(String weatherSourceId) {
    this.weatherSourceId = weatherSourceId;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getTideSourceId() {
    return tideSourceId;
  }

  public void setTideSourceId(String tideSourceId) {
    this.tideSourceId = tideSourceId;
  }

  public String getTideSourceName() {
    return tideSourceName;
  }

  public void setTideSourceName(String tideSourceName) {
    this.tideSourceName = tideSourceName;
  }

  public String getCurrentSourceId() {
    return currentSourceId;
  }

  public void setCurrentSourceId(String currentSourceId) {
    this.currentSourceId = currentSourceId;
  }

  public String getCurrentSourceName() {
    return currentSourceName;
  }

  public void setCurrentSourceName(String currentSourceName) {
    this.currentSourceName = currentSourceName;
  }

  public String getRadarSource() {
    return radarSource;
  }

  public void setRadarSource(String radarSource) {
    this.radarSource = radarSource;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  @Override
  public String toString() {
    return "{\n  \"Station\": {\n    \"id\":\"" + id + "\", \n    \"stationId\":\"" + stationId
            + "\", \n    \"stationName\":\"" + stationName + "\", \n    \"waveSourceId\":\""
            + waveSourceId + "\", \n    \"waveSourceName\":\"" + waveSourceName
            + "\", \n    \"waveSourceId2\":\"" + waveSourceId2 + "\", \n    \"waveSourceName2\":\""
            + waveSourceName2 + "\", \n    \"windSourceId\":\"" + windSourceId
            + "\", \n    \"windSourceName\":\"" + windSourceName
            + "\", \n    \"weatherSourceId\":\"" + weatherSourceId + "\", \n    \"city\":\"" + city
            + "\", \n    \"tideSourceId\":\"" + tideSourceId + "\", \n    \"tideSourceName\":\""
            + tideSourceName + "\", \n    \"currentSourceId\":\"" + currentSourceId
            + "\", \n    \"currentSourceName\":\"" + currentSourceName
            + "\", \n    \"radarSource\":\"" + radarSource + "\", \n    \"timeZone\":\"" + timeZone
            + "\"\n  }\n}";
  }

}

