package com.shawncrahen.application.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Service;
import com.shawncrahen.application.api.TideApiResponse;
import com.shawncrahen.application.api.tide.TidePredictions;
import com.shawncrahen.application.data.CalculatedNextTide;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.task.scheduled.ScheduledTidePredictionsApiUpdater;
import com.shawncrahen.application.utility.DateTimeFormatUtility;

@Service
public class NextTideService {

  private ScheduledTidePredictionsApiUpdater scheduledTideApiUpdater;
  private StationService stationService;

  public NextTideService(ScheduledTidePredictionsApiUpdater scheduleTideApiUpdater,
          StationService stationService) {
    this.scheduledTideApiUpdater = scheduleTideApiUpdater;
    this.stationService = stationService;
  }

  public CalculatedNextTide getNextTide() {
    Station station = stationService.getStation();
    TideApiResponse tideApiResponse = scheduledTideApiUpdater.getTideApiResponse();
    TidePredictions[] predictions = tideApiResponse.getPredictions();

    ZonedDateTime now = ZonedDateTime.now(ZoneId.of(station.getTimeZone()));
    int i = 0;
    while (now.compareTo(
            ZonedDateTime.of(predictions[i].getDateTime(), ZoneId.of(station.getTimeZone()))) > 0) {
      i++;
    }
    return new CalculatedNextTide(
            predictions[i].getDateTime().format(DateTimeFormatUtility.getTimeOnlyFormatter()),
            predictions[i].getType());
  }

}
