package com.shawncrahen.application.task;

import java.time.LocalDate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.api.CurrentApiResponse;

@Component
public class ScheduledCurrentPredictionsApiUpdater {

  private RestTemplate restTemplate;
  private CurrentApiResponse currentApiResponse = new CurrentApiResponse();

  private ScheduledCurrentPredictionsApiUpdater(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public CurrentApiResponse getCurrentApiResponse() {
    return currentApiResponse;
  }

  public void setCurrentApiResponse(CurrentApiResponse currentApiResponse) {
    this.currentApiResponse = currentApiResponse;
  }

  @Scheduled(fixedRate = 43200000)
  private void updateCurrentPrediction() {
    String todayString = LocalDate.now().toString().replaceAll("-", "");
    currentApiResponse = restTemplate.getForObject(
            "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?station=ACT0816&begin_date="
                    + todayString
                    + "&range=36&product=currents_predictions&units=english&time_zone=lst_ldt&format=json",
            CurrentApiResponse.class);
  }

}
