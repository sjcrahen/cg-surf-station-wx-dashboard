package com.shawncrahen.application.task.scheduled;

import java.time.LocalDate;
import java.time.ZoneId;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.data.CurrentDto;
import com.shawncrahen.application.data.current.CurrentPrediction;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;

@Component
public class ScheduledCurrentPredictionsUpdater implements ScheduledUpdater {

  private RestTemplate restTemplate;
  private StationService stationService;
  private CurrentDto currentDto = new CurrentDto();

  private ScheduledCurrentPredictionsUpdater(RestTemplate restTemplate,
          StationService stationService) {
    this.restTemplate = restTemplate;
    this.stationService = stationService;
  }

  public CurrentDto getCurrentApiResponse() {
    return currentDto;
  }

  public void setCurrentApiResponse(CurrentDto currentApiResponse) {
    this.currentDto = currentApiResponse;
  }

  @Override
  @Scheduled(fixedRate = 43200000)
  public void update() {
    Station station = stationService.getStation();
    if (station != null && station.getCurrentSourceId() == null) {
      currentDto.reset();
    }
    if (station != null && station.getCurrentSourceId() != null) {
      String yesterdayString =
              LocalDate.now(ZoneId.of(station.getTimeZone())).minusDays(1).toString()
                      .replaceAll("-", "");
      currentDto = restTemplate.getForObject(
              "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?station="
                      + station.getCurrentSourceId()
                      + "&begin_date="
                      + yesterdayString
                      + "&range=60&product=currents_predictions&units=english&time_zone=lst_ldt&format=json&interval=MAX_SLACK",
              CurrentDto.class);
      for (CurrentPrediction prediction : currentDto.getCurrent_predictions().getPredictions()) {
        prediction.setDateTime(prediction.getTime());
      }
    }
  }

}
