package com.shawncrahen.application.data;

import java.time.ZonedDateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.shawncrahen.application.utility.DirectionMapper;

@Component
@Scope("prototype")
public class SeasObservation {

  private ZonedDateTime dateTime;
  private String dateTimeString;
  private String waveHeight;
  private String dominantPeriod;
  private String waveDirection;
  private String direction;
  private boolean outDated;

  public SeasObservation() {}

  public ZonedDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(ZonedDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String getDateTimeString() {
    return dateTimeString;
  }

  public void setDateTimeString(String dateTimeString) {
    this.dateTimeString = dateTimeString;
  }

  public String getWaveHeight() {
    return waveHeight;
  }

  public void setWaveHeight(String waveHeight) {
    this.waveHeight = waveHeight;
  }

  public String getDominantPeriod() {
    return dominantPeriod;
  }

  public void setDominantPeriod(String dominantPeriod) {
    this.dominantPeriod = dominantPeriod;
  }

  public String getWaveDirection() {
    return waveDirection;
  }

  public void setWaveDirection(String direction) {
    this.waveDirection = direction;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(long direction) {
    this.direction = DirectionMapper.mapDirection(direction);
  }

  public boolean isOutDated() {
    return outDated;
  }

  public void setOutDated(boolean outDated) {
    this.outDated = outDated;
  }

  @Override
  public String toString() {
    return "{\n  \"SeasObservation\": {\n    \"dateTime\":\"" + dateTime
            + "\", \n    \"dateTimeString\":\"" + dateTimeString + "\", \n    \"waveHeight\":\""
            + waveHeight + "\", \n    \"dominantPeriod\":\"" + dominantPeriod
            + "\", \n    \"waveDirection\":\"" + waveDirection + "\", \n    \"direction\":\""
            + direction + "\", \n    \"outDated\":\"" + outDated + "\"\n  }\n}";
  }

}
