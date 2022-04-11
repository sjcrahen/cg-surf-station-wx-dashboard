package com.shawncrahen.application.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.WeatherDto;
import com.shawncrahen.application.task.scheduled.ScheduledWeatherUpdater;

@Service
@Scope("session")
public class WeatherService {

  ScheduledWeatherUpdater scheduledWeatherUpdater;

  private WeatherService(ScheduledWeatherUpdater scheduledWeatherUpdater) {
    this.scheduledWeatherUpdater = scheduledWeatherUpdater;
  }

  public WeatherDto getCurrentWeather() {
    return scheduledWeatherUpdater.getWeatherDto();
  }

}
