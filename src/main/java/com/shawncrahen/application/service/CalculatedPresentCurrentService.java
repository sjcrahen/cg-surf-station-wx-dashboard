package com.shawncrahen.application.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.data.CalculatedPresentCurrent;
import com.shawncrahen.application.data.StationDto;
import com.shawncrahen.application.rest.current.CurrentApiObject;
import com.shawncrahen.application.rest.current.CurrentPrediction;

@Service
public class CalculatedPresentCurrentService {

  private RestTemplate restTemplate;

  public CalculatedPresentCurrentService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public CalculatedPresentCurrent getCalculatedPresentCurrent(StationDto station) {
    if (station.getCurrentSourceId() == null)
      return null;

    String yesterdayString =
            LocalDate.now(ZoneId.of(station.getTimeZone())).minusDays(1).toString()
                    .replaceAll("-", "");
    CurrentApiObject currentResponse = restTemplate.getForObject(
            "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?station="
                    + station.getCurrentSourceId()
                    + "&begin_date="
                    + yesterdayString
                    + "&range=60&product=currents_predictions&units=english&time_zone=lst_ldt&format=json&interval=MAX_SLACK",
            CurrentApiObject.class);
    for (CurrentPrediction prediction : currentResponse.getCurrent_predictions().getPredictions()) {
      prediction.setDateTime(prediction.getTime());
    }
    CurrentPrediction[] predictions =
            currentResponse.getCurrent_predictions().getPredictions();

    ZonedDateTime now = ZonedDateTime.now(ZoneId.of(station.getTimeZone()));
    int i = 0;
    while (now.compareTo(
            ZonedDateTime.of(predictions[i].getDateTime(), ZoneId.of(station.getTimeZone()))) > 0) {
      i++;
    }
    CurrentPrediction first = predictions[i - 1];
    CurrentPrediction last = predictions[i];
    Duration periodDuration = Duration.between(first.getDateTime(), last.getDateTime());
    Duration diffFromNow = Duration.between(first.getDateTime(), now);

    double firstVelocity = Double.parseDouble(first.getVelocity());
    double lastVelocity = Double.parseDouble(last.getVelocity());
    double velocityChangePerMinute = (lastVelocity - firstVelocity) / periodDuration.toMinutes();
    double presentCurrent = firstVelocity + (diffFromNow.toMinutes() * velocityChangePerMinute);


    CurrentPrediction nextSlackCurrent =
            Math.abs(Double.parseDouble(first.getVelocity())) < 0.5 ? predictions[i + 1] : last;
    String nextSlackTime =
            nextSlackCurrent.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));
    String thisSlackTime =
            Math.abs(Double.parseDouble(first.getVelocity())) < 0.5
                    ? first.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm"))
                    : last.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));

    return new CalculatedPresentCurrent(now.format(DateTimeFormatter.ofPattern("HH:mm")),
            presentCurrent, first.getMeanEbbDir(), first.getMeanFloodDir(), thisSlackTime,
            nextSlackTime, lastVelocity);
  }

}
