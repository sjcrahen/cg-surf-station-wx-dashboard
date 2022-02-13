package com.shawncrahen.application.task.scheduled;

import java.time.LocalDate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.api.TideApiResponse;
import com.shawncrahen.application.api.tide.TidePredictions;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;

@Component
public class ScheduledTidePredictionsApiUpdater implements ScheduledApiUpdater {

  private RestTemplate restTemplate;
  private StationService stationService;
  private TideApiResponse tideApiResponse;

  private ScheduledTidePredictionsApiUpdater(RestTemplate restTemplate,
          StationService stationService) {
    this.restTemplate = restTemplate;
    this.stationService = stationService;
  }

  public TideApiResponse getTideApiResponse() {
    return tideApiResponse;
  }

  public void setTideApiResponse(TideApiResponse tideApiResponse) {
    this.tideApiResponse = tideApiResponse;
  }

  @Override
  @Scheduled(fixedRate = 43200000)
  public void update() {
    Station station = stationService.getStation();
    if (station != null) {
      String todayString = LocalDate.now().toString().replaceAll("-", "");
      tideApiResponse = restTemplate.getForObject(
              "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?begin_date="
                      + todayString
                      + "&range=36&station="
                      + station.getTideSourceId()
                      + "&product=predictions&datum=mllw&interval=hilo&units=english&time_zone=lst_ldt&format=json",
              TideApiResponse.class);
      for (TidePredictions prediction : tideApiResponse.getPredictions()) {
        prediction.setDateTime(prediction.getTime());
      }
    }
  }
}
