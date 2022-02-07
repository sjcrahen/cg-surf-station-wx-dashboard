package com.shawncrahen.application.api.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

  private int temp_f;
  private Condition condition;
  private int wind_mph;

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

}
