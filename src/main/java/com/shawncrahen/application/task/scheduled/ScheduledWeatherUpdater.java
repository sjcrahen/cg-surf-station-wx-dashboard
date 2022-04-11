package com.shawncrahen.application.task.scheduled;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.data.WeatherDto;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;

@Component
@Scope("session")
public class ScheduledWeatherUpdater implements ScheduledUpdater {

  private RestTemplate restTemplate;
  private StationService stationService;
  private WeatherDto weatherDto = new WeatherDto();

  private ScheduledWeatherUpdater(RestTemplate restTemplate, StationService stationService) {
    this.restTemplate = restTemplate;
    this.stationService = stationService;
  }

  public WeatherDto getWeatherDto() {
    return weatherDto;
  }

  public void setWeatherDto(WeatherDto weatherApiResponse) {
    this.weatherDto = weatherApiResponse;
  }

  @Override
  @Scheduled(fixedRate = 900000)
  public void update() {
    Station station = stationService.getStation();
    if (station != null) {
      weatherDto = restTemplate.getForObject(
              "http://api.weatherapi.com/v1/forecast.json?key=3436a533716643b989d191452220402&q="
                      + station.getWeatherSourceId()
                      + "&aqi=no",
              WeatherDto.class);
      weatherDto.setChanceOfPrecip();
    }
  }

}
