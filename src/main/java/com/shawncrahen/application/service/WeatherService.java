package com.shawncrahen.application.service;

import org.springframework.stereotype.Service;
import com.shawncrahen.application.api.WeatherApiResponse;
import com.shawncrahen.application.task.ScheduledWeatherApiUpdater;

@Service
public class WeatherService {

  ScheduledWeatherApiUpdater scheduledWeatherApiUpdater;

  private WeatherService(ScheduledWeatherApiUpdater scheduledWeatherApiUpdater) {
    this.scheduledWeatherApiUpdater = scheduledWeatherApiUpdater;
  }

  public WeatherApiResponse getCurrentWeather() {
    return scheduledWeatherApiUpdater.getWeatherApiResponse();
  }

}
