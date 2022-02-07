package com.shawncrahen.application.rest;

import com.shawncrahen.application.rest.weather.CurrentWeather;

public class WeatherApiResponse {

  private CurrentWeather current;

  private WeatherApiResponse() {}

  public CurrentWeather getCurrent() {
    return current;
  }

  public void setCurrent(CurrentWeather current) {
    this.current = current;
  }



}
