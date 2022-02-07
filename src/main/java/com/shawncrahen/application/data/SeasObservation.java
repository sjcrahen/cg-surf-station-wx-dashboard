package com.shawncrahen.application.data;

import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;

@Component
public class SeasObservation {

  private ZonedDateTime dateTime;
  private String dateTimeString;
  private int year;
  private int month;
  private int day;
  private int hour;
  private int minute;
  private String waveHeight;
  private String dominantPeriod;
  private String waveDirection;

  public SeasObservation() {}

  public int getYear() {
    return year;
  }

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

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
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

  public void setWaveDirection(String waveDirection) {
    this.waveDirection = waveDirection;
  }

  @Override
  public String toString() {
    return "{\n  \"WaveDataSource\": {\n    \"dateTime\":\"" + dateTime + "\", \n    \"year\":\""
            + year + "\", \n    \"month\":\"" + month + "\", \n    \"day\":\"" + day
            + "\", \n    \"hour\":\"" + hour + "\", \n    \"minute\":\"" + minute
            + "\", \n    \"waveHeight\":\"" + waveHeight + "\", \n    \"dominantPeriod\":\""
            + dominantPeriod + "\", \n    \"waveDirection\":\"" + waveDirection + "\"\n  }\n}";
  }

}
