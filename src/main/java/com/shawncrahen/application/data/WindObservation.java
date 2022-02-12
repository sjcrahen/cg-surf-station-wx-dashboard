package com.shawncrahen.application.data;

import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;
import com.shawncrahen.application.utility.DirectionMapper;

@Component
public class WindObservation {

  private ZonedDateTime dateTime;
  private String dateTimeString;
  private int year;
  private int month;
  private int day;
  private int hour;
  private int minute;
  private String windDirection;
  private String direction;
  private int windSpeed;
  private int windGust;

  public WindObservation() {}

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

  public int getYear() {
    return year;
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

  public String getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(String windDirection) {
    this.windDirection = windDirection;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(long direction) {
    this.direction = DirectionMapper.mapDirection(direction);
  }

  public int getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(int windSpeed) {
    this.windSpeed = windSpeed;
  }

  public int getWindGust() {
    return windGust;
  }

  public void setWindGust(int windGust) {
    this.windGust = windGust;
  }

  @Override
  public String toString() {
    return "{\n  \"WindDataSource\": {\n    \"dateTime\":\"" + dateTime + "\", \n    \"year\":\""
            + year + "\", \n    \"month\":\"" + month + "\", \n    \"day\":\"" + day
            + "\", \n    \"hour\":\"" + hour + "\", \n    \"minute\":\"" + minute
            + "\", \n    \"windDirection\":\"" + windDirection + "\", \n    \"windSpeed\":\""
            + windSpeed + "\", \n    \"windGust\":\"" + windGust + "\"\n  }\n}";
  }

}
