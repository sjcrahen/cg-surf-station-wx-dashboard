package com.shawncrahen.application.entity;

import org.springframework.stereotype.Component;

@Component
public class Station {

  private String stationId;
  private String stationName = "Merrimack River";
  private String wavesSourceId = "44098";
  private String windSourceId = "IOSN3";
  private String weatherSourceId = "01950";
  private String tideSourceId = "8440452";
  private String currentSourceId = "ACT0816";

  public Station() {}

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
    return wavesSourceId;
  }

  public void setWavesSourceId(String wavesSourceId) {
    this.wavesSourceId = wavesSourceId;
  }

  public String getWindSourceId() {
    return windSourceId;
  }

  public void setWindSourceId(String windSourceId) {
    this.windSourceId = windSourceId;
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

  @Override
  public String toString() {
    return "{\n  \"Station\": {\n    \"stationId\":\"" + stationId + "\", \n    \"stationName\":\""
            + stationName + "\", \n    \"wavesSourceId\":\"" + wavesSourceId
            + "\", \n    \"windSourceId\":\"" + windSourceId + "\", \n    \"weatherSourceId\":\""
            + weatherSourceId + "\", \n    \"tideSourceId\":\"" + tideSourceId
            + "\", \n    \"currentSourceId\":\"" + currentSourceId + "\"\n  }\n}";
  }

}
