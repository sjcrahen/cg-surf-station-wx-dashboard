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

  @Column(name = "waves_source_url")
  private String waveSourceUrl;

  @Column(name = "wind_source_id")
  private String windSourceId;

  @Column(name = "wind_source_name")
  private String windSourceName;

  @Column(name = "wind_source_url")
  private String windSourceUrl;

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

  private Station(String stationId, String stationName, String wavesSourceId, String wavesSourceUrl,
          String windSourceId, String windSourceUrl, String weatherSourceId, String tideSourceId,
          String currentSourceId) {
    this.stationId = stationId;
    this.stationName = stationName;
    this.waveSourceId = wavesSourceId;
    this.waveSourceUrl = wavesSourceUrl;
    this.windSourceId = windSourceId;
    this.windSourceUrl = windSourceUrl;
    this.weatherSourceId = weatherSourceId;
    this.tideSourceId = tideSourceId;
    this.currentSourceId = currentSourceId;
  }

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

  public String getWavesSourceId() {
    return waveSourceId;
  }

  public void setWavesSourceId(String wavesSourceId) {
    this.waveSourceId = wavesSourceId;
  }

  public String getWavesSourceUrl() {
    return waveSourceUrl;
  }

  public void setWavesSourceUrl(String wavesSourceUrl) {
    this.waveSourceUrl = wavesSourceUrl;
  }

  public String getWindSourceId() {
    return windSourceId;
  }

  public void setWindSourceId(String windSourceId) {
    this.windSourceId = windSourceId;
  }

  public String getWindSourceUrl() {
    return windSourceUrl;
  }

  public void setWindSourceUrl(String windSourceUrl) {
    this.windSourceUrl = windSourceUrl;
  }

  public String getWeatherSourceId() {
    return weatherSourceId;
  }

  public void setWeatherSourceId(String weatherSourceId) {
    this.weatherSourceId = weatherSourceId;
  }

  public String getTideSourceId() {
    return tideSourceId;
  }

  public void setTideSourceId(String tideSourceId) {
    this.tideSourceId = tideSourceId;
  }

  public String getCurrentSourceId() {
    return currentSourceId;
  }

  public void setCurrentSourceId(String currentSourceId) {
    this.currentSourceId = currentSourceId;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getWavesSourceName() {
    return waveSourceName;
  }

  public void setWavesSourceName(String wavesSourceName) {
    this.waveSourceName = wavesSourceName;
  }

  public String getWindSourceName() {
    return windSourceName;
  }

  public void setWindSourceName(String windSourceName) {
    this.windSourceName = windSourceName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getTideSourceName() {
    return tideSourceName;
  }

  public void setTideSourceName(String tideSourceName) {
    this.tideSourceName = tideSourceName;
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

  public String getCurrentSourceName() {
    return currentSourceName;
  }

  public void setCurrentSourceName(String currentSourceName) {
    this.currentSourceName = currentSourceName;
  }

  @Override
  public String toString() {
    return "{\n  \"Station\": {\n    \"id\":\"" + id + "\", \n    \"stationId\":\"" + stationId
            + "\", \n    \"stationName\":\"" + stationName + "\", \n    \"wavesSourceId\":\""
            + waveSourceId + "\", \n    \"wavesSourceName\":\"" + waveSourceName
            + "\", \n    \"wavesSourceUrl\":\"" + waveSourceUrl + "\", \n    \"windSourceId\":\""
            + windSourceId + "\", \n    \"windSourceName\":\"" + windSourceName
            + "\", \n    \"windSourceUrl\":\"" + windSourceUrl + "\", \n    \"weatherSourceId\":\""
            + weatherSourceId + "\", \n    \"city\":\"" + city + "\", \n    \"tideSourceId\":\""
            + tideSourceId + "\", \n    \"tideSourceName\":\"" + tideSourceName
            + "\", \n    \"currentSourceId\":\"" + currentSourceId + "\", \n    \"radarSource\":\""
            + radarSource + "\", \n    \"timeZone\":\"" + timeZone + "\"\n  }\n}";
  }

}
