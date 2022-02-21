package com.shawncrahen.application.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shawncrahen.application.data.weather.CurrentWeather;
import com.shawncrahen.application.data.weather.Forecast;
import com.shawncrahen.application.data.weather.ForecastDay;

public class WeatherDto {

  @JsonProperty("current")
  private CurrentWeather currentWeather;
  private Forecast forecast;

  public WeatherDto() {}

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

  public void setChanceOfPrecip() {
    for (ForecastDay forecastDay : forecast.getForecastDay()) {
      forecastDay.getDay().setChance_of_precip();
    }
  }

  @Override
  public String toString() {
    return "{\n  \"WeatherApiResponse\": {\n    \"currentWeather\":\"" + currentWeather
            + "\", \n    \"forecast\":\"" + forecast + "\"\n  }\n}";
  }

}