package com.shawncrahen.application.service;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.CalculatedPresentCurrent;
import com.shawncrahen.application.data.CurrentDto;
import com.shawncrahen.application.data.current.CurrentPrediction;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.task.scheduled.ScheduledCurrentPredictionsUpdater;

@Service
public class CalculatedPresentCurrentService {

  private ScheduledCurrentPredictionsUpdater scheduledCurrentPredictionsUpdater;
  private StationService stationService;

  private CalculatedPresentCurrentService(
          ScheduledCurrentPredictionsUpdater scheduledCurrentPredictionsUpdater,
          StationService stationService) {
    this.scheduledCurrentPredictionsUpdater = scheduledCurrentPredictionsUpdater;
    this.stationService = stationService;
  }

  public CalculatedPresentCurrent getCalculatedPresentCurrent() {
    Station station = stationService.getStation();
    if (station.getCurrentSourceId() == null)
      return null;
    CurrentDto currentApiResponse =
            scheduledCurrentPredictionsUpdater.getCurrentApiResponse();
    CurrentPrediction[] predictions =
            currentApiResponse.getCurrent_predictions().getPredictions();

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

    return new CalculatedPresentCurrent(now.format(DateTimeFormatter.ofPattern("HH:mm")),
            presentCurrent, first.getMeanEbbDir(), first.getMeanFloodDir(), first.getTime(),
            nextSlackTime, lastVelocity);
  }

}
