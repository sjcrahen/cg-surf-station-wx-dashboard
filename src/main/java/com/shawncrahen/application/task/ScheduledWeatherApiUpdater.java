package com.shawncrahen.application.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.api.WeatherApiResponse;

@Component
public class ScheduledWeatherApiUpdater {

  private RestTemplate restTemplate;
  private WeatherApiResponse weatherApiResponse = new WeatherApiResponse();

  private ScheduledWeatherApiUpdater(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public WeatherApiResponse getWeatherApiResponse() {
    return weatherApiResponse;
  }

  public void setWeatherApiResponse(WeatherApiResponse weatherApiResponse) {
    this.weatherApiResponse = weatherApiResponse;
  }

  @Scheduled(fixedRate = 900000)
  private void updateWeather() {
    weatherApiResponse = restTemplate.getForObject(
            "http://api.weatherapi.com/v1/current.json?key=3436a533716643b989d191452220402&q=01950&aqi=no",
            WeatherApiResponse.class);
  }

}
