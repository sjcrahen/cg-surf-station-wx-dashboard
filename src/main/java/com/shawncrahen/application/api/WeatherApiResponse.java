package com.shawncrahen.application.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shawncrahen.application.api.weather.CurrentWeather;
import com.shawncrahen.application.api.weather.Forecast;

public class WeatherApiResponse {

  @JsonProperty("current")
  private CurrentWeather currentWeather;
  private Forecast forecast;

  public WeatherApiResponse() {}

  public CurrentWeather getCurrentWeather() {
    return currentWeather;
  }

  public void setCurrentWeather(CurrentWeather currentWeather) {
    this.currentWeather = currentWeather;
  }

  public Forecast getForecast() {
    return forecast;
  }

  public void setForecast(Forecast forecast) {
    this.forecast = forecast;
  }

  @Override
  public String toString() {
    return "{\n  \"WeatherApiResponse\": {\n    \"currentWeather\":\"" + currentWeather
            + "\", \n    \"forecast\":\"" + forecast + "\"\n  }\n}";
  }

}
