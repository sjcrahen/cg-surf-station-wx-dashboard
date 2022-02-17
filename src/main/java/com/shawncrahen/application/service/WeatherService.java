package com.shawncrahen.application.service;

import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.WeatherDto;
import com.shawncrahen.application.task.scheduled.ScheduledWeatherUpdater;

@Service
public class WeatherService {

  ScheduledWeatherUpdater scheduledWeatherApiUpdater;

  private WeatherService(ScheduledWeatherUpdater scheduledWeatherApiUpdater) {
    this.scheduledWeatherApiUpdater = scheduledWeatherApiUpdater;
  }

  public WeatherDto getCurrentWeather() {
    return scheduledWeatherApiUpdater.getWeatherDto();
  }

}
