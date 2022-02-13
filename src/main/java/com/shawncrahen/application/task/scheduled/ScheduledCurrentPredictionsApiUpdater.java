package com.shawncrahen.application.task.scheduled;

import java.time.LocalDate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.api.CurrentApiResponse;
import com.shawncrahen.application.api.current.CurrentPrediction;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;

@Component
public class ScheduledCurrentPredictionsApiUpdater implements ScheduledApiUpdater {

  private RestTemplate restTemplate;
  private StationService stationService;
  private CurrentApiResponse currentApiResponse = new CurrentApiResponse();

  private ScheduledCurrentPredictionsApiUpdater(RestTemplate restTemplate,
          StationService stationService) {
    this.restTemplate = restTemplate;
    this.stationService = stationService;
  }

  public CurrentApiResponse getCurrentApiResponse() {
    return currentApiResponse;
  }

  public void setCurrentApiResponse(CurrentApiResponse currentApiResponse) {
    this.currentApiResponse = currentApiResponse;
  }

  @Override
  @Scheduled(fixedRate = 43200000)
  public void update() {
    Station station = stationService.getStation();
    if (station != null && station.getCurrentSourceId() == null) {
      currentApiResponse.reset();
    }
    if (station != null && station.getCurrentSourceId() != null) {
      String todayString = LocalDate.now().toString().replaceAll("-", "");
      currentApiResponse = restTemplate.getForObject(
              "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?station="
                      + station.getCurrentSourceId()
                      + "&begin_date="
                      + todayString
                      + "&range=36&product=currents_predictions&units=english&time_zone=lst_ldt&format=json",
              CurrentApiResponse.class);
      for (CurrentPrediction prediction : currentApiResponse.getCurrent_predictions()
              .getPredictions()) {
        prediction.setDateTime(prediction.getTime());
      }
    }
  }

}
