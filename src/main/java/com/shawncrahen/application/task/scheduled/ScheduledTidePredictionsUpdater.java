package com.shawncrahen.application.task.scheduled;

import java.time.LocalDate;
import java.time.ZoneId;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.data.TideDto;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;

@Component
public class ScheduledTidePredictionsUpdater implements ScheduledUpdater {

  private RestTemplate restTemplate;
  private StationService stationService;
  private TideDto tideDto;

  private ScheduledTidePredictionsUpdater(RestTemplate restTemplate,
          StationService stationService) {
    this.restTemplate = restTemplate;
    this.stationService = stationService;
  }

  public TideDto getTideDto() {
    return tideDto;
  }

  public void setTideDto(TideDto tideDto) {
    this.tideDto = tideDto;
  }

  @Override
  @Scheduled(fixedRate = 43200000)
  public void update() {
    Station station = stationService.getStation();
    if (station != null) {
      String todayString =
              LocalDate.now(ZoneId.of(station.getTimeZone())).toString().replaceAll("-", "");
      tideDto = restTemplate.getForObject(
              "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?begin_date="
                      + todayString
                      + "&range=48&station="
                      + station.getTideSourceId()
                      + "&product=predictions&datum=mllw&interval=hilo&units=english&time_zone=lst_ldt&format=json",
              TideDto.class);
    }
  }
}
