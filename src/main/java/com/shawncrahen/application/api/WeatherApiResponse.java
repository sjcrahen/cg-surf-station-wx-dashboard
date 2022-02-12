package com.shawncrahen.application.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shawncrahen.application.api.weather.CurrentWeather;
import com.shawncrahen.application.api.weather.Forecast;
import com.shawncrahen.application.api.weather.ForecastDay;

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

  public void setChanceOfPrecip() {
    for (ForecastDay forecastDay : forecast.getForecastDay()) {
      forecastDay.getDay().setChance_of_precip();
    }
  }

  // public void setCurrentWeatherDateTime() {
  // String dateTimeString = currentWeather.getLast_updated();
  // dateTimeString = dateTimeString.replaceAll("[-:]", " ");
  // String[] dt = dateTimeString.split(" ");
  // LocalDateTime localDt = LocalDateTime.of(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]),
  // Integer.parseInt(dt[2]), Integer.parseInt(dt[3]), Integer.parseInt(dt[4]));
  // ZonedDateTime zdt = ZonedDateTime.of(localDt, ZoneId.of("America/New_York"));
  // System.out.println(zdt);
  // currentWeather.setDateTime(zdt);
  // }

  @Override
  public String toString() {
    return "{\n  \"WeatherApiResponse\": {\n    \"currentWeather\":\"" + currentWeather
            + "\", \n    \"forecast\":\"" + forecast + "\"\n  }\n}";
  }

}
