package com.shawncrahen.application.task.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.api.WeatherApiResponse;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;

@Component
public class ScheduledWeatherApiUpdater implements ScheduledApiUpdater {

  private RestTemplate restTemplate;
  private StationService stationService;
  private WeatherApiResponse weatherApiResponse = new WeatherApiResponse();

  private ScheduledWeatherApiUpdater(RestTemplate restTemplate, StationService stationService) {
    this.restTemplate = restTemplate;
    this.stationService = stationService;
  }

  public WeatherApiResponse getWeatherApiResponse() {
    return weatherApiResponse;
  }

  public void setWeatherApiResponse(WeatherApiResponse weatherApiResponse) {
    this.weatherApiResponse = weatherApiResponse;
  }

  @Override
  @Scheduled(fixedRate = 900000)
  public void update() {
    Station station = stationService.getStation();
    if (station != null) {
      weatherApiResponse = restTemplate.getForObject(
              "http://api.weatherapi.com/v1/forecast.json?key=3436a533716643b989d191452220402&q="
                      + station.getWeatherSourceId()
                      + "&aqi=no",
              WeatherApiResponse.class);
      weatherApiResponse.setChanceOfPrecip();
    }
  }

}
