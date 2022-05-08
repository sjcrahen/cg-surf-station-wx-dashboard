package com.shawncrahen.application.data;

public class StationDto implements Comparable<StationDto> {

  private String stationId;
  private String stationName;
  private String waveSourceId;
  private String waveSourceName;
  private String waveSourceId2 = null;
  private String waveSourceName2 = null;
  private String windSourceId;
  private String windSourceName;
  private String weatherSourceId;
  private String city;
  private String tideSourceId;
  private String tideSourceName;
  private String currentSourceId;
  private String currentSourceName;
  private String radarSource;
  private String timeZone;
  private String forecastSource = null;

  public StationDto() {}

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

  public String getForecastSource() {
    return forecastSource;
  }

  public void setForecastSource(String forecastSource) {
    this.forecastSource = forecastSource;
  }

  @Override
  public String toString() {
    return "{\n  \"Station\": {\n    \"stationId\":\"" + stationId + "\", \n    \"stationName\":\""
            + stationName + "\", \n    \"waveSourceId\":\"" + waveSourceId
            + "\", \n    \"waveSourceName\":\"" + waveSourceName + "\", \n    \"waveSourceId2\":\""
            + waveSourceId2 + "\", \n    \"waveSourceName2\":\"" + waveSourceName2
            + "\", \n    \"windSourceId\":\"" + windSourceId + "\", \n    \"windSourceName\":\""
            + windSourceName + "\", \n    \"weatherSourceId\":\"" + weatherSourceId
            + "\", \n    \"city\":\"" + city + "\", \n    \"tideSourceId\":\"" + tideSourceId
            + "\", \n    \"tideSourceName\":\"" + tideSourceName
            + "\", \n    \"currentSourceId\":\"" + currentSourceId
            + "\", \n    \"currentSourceName\":\"" + currentSourceName
            + "\", \n    \"radarSource\":\"" + radarSource + "\", \n    \"timeZone\":\"" + timeZone
            + "\", \n    \"forecastSource\":\"" + forecastSource + "\"\n  }\n}";
  }

  @Override
  public int compareTo(StationDto o) {
    return this.stationName.compareTo(o.getStationName());
  }

}
