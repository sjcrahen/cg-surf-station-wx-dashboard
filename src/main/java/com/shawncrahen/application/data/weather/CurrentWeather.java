package com.shawncrahen.application.data.weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

  private int temp_f;
  private Condition condition;
  private int wind_mph;
  private String wind_dir;
  private int gust_mph;
  private int feelslike_f;
  private String last_updated;

  private CurrentWeather() {}

  public int getTemp_f() {
    return temp_f;
  }

  public void setTemp_f(double temp_f) {
    this.temp_f = (int) Math.round(temp_f);
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public int getWind_mph() {
    return wind_mph;
  }

  public void setWind_mph(double wind_mph) {
    this.wind_mph = (int) Math.round(wind_mph);
  }

  public String getWind_dir() {
    return wind_dir;
  }

  public void setWind_dir(String wind_dir) {
    this.wind_dir = wind_dir;
  }

  public int getGust_mph() {
    return gust_mph;
  }

  public void setGust_mph(double gust_mph) {
    this.gust_mph = (int) Math.round(gust_mph);
  }

  public int getFeelslike_f() {
    return feelslike_f;
  }

  public void setFeelslike_f(double feelslike_f) {
    this.feelslike_f = (int) Math.round(feelslike_f);
  }

  public String getLast_updated() {
    return last_updated;
  }

  public void setLast_updated(String last_updated) throws ParseException {
    SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
    SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date date = parseFormat.parse(last_updated);
    this.last_updated = displayFormat.format(date);
  }

  @Override
  public String toString() {
    return "{\n  \"CurrentWeather\": {\n    \"temp_f\":\"" + temp_f + "\", \n    \"condition\":\""
            + condition + "\", \n    \"wind_mph\":\"" + wind_mph + "\", \n    \"wind_dir\":\""
            + wind_dir + "\", \n    \"gust_mph\":\"" + gust_mph + "\", \n    \"feelslike_f\":\""
            + feelslike_f + "\", \n    \"last_updated\":\"" + last_updated + "\"\n  }\n}";
  }

}
