package com.shawncrahen.application.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shawncrahen.application.api.weather.CurrentWeather;

public class WeatherApiResponse {

  @JsonProperty("current")
  private CurrentWeather currentWeather;

  public WeatherApiResponse() {}

  public CurrentWeather getCurrentWeather() {
    return currentWeather;
  }

  public void setCurrentWeather(CurrentWeather currentWeather) {
    this.currentWeather = currentWeather;
  }

  @Override
  public String toString() {
    return "{\n  \"WeatherApiResponse\": {\n    \"currentWeather\":\"" + currentWeather
            + "\"\n  }\n}";
  }

}
