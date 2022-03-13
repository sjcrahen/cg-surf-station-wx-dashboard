package com.shawncrahen.application.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.CalculatedNextTide;
import com.shawncrahen.application.data.TideDto;
import com.shawncrahen.application.data.tide.TidePredictions;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.task.scheduled.ScheduledTidePredictionsUpdater;

@Service
public class NextTideService {

  private ScheduledTidePredictionsUpdater scheduledTideApiUpdater;
  private StationService stationService;

  public NextTideService(ScheduledTidePredictionsUpdater scheduleTideApiUpdater,
          StationService stationService) {
    this.scheduledTideApiUpdater = scheduleTideApiUpdater;
    this.stationService = stationService;
  }

  public CalculatedNextTide getNextTide() {
    Station station = stationService.getStation();
    TideDto tideApiResponse = scheduledTideApiUpdater.getTideDto();
    TidePredictions[] predictions = tideApiResponse.getPredictions();
    System.out.println(Arrays.toString(predictions));

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
