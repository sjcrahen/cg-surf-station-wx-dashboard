package com.shawncrahen.application.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.data.CalculatedNextTide;
import com.shawncrahen.application.data.StationDto;
import com.shawncrahen.application.rest.tide.TideApiResponse;
import com.shawncrahen.application.rest.tide.TidePredictions;

@Service
public class NextTideService {

  private RestTemplate restTemplate;

  public NextTideService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public CalculatedNextTide getNextTide(StationDto station) {
    String todayString =
            LocalDate.now(ZoneId.of(station.getTimeZone())).toString().replaceAll("-", "");
    TideApiResponse tides = restTemplate.getForObject(
            "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?begin_date="
                    + todayString
                    + "&range=48&station="
                    + station.getTideSourceId()
                    + "&product=predictions&datum=mllw&interval=hilo&units=english&time_zone=lst_ldt&format=json",
            TideApiResponse.class);
    TidePredictions[] predictions = tides.getPredictions();

    ZonedDateTime now = ZonedDateTime.now(ZoneId.of(station.getTimeZone()));
    int i = 0;
    while (now.compareTo(
            ZonedDateTime.of(predictions[i].getDateTime(), ZoneId.of(station.getTimeZone()))) > 0) {
      i++;
    }
    return new CalculatedNextTide(
            predictions[i].getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")),
            predictions[i].getType(), predictions[i].getHeight());
  }

}
