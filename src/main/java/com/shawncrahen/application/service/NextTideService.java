package com.shawncrahen.application.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Service;
import com.shawncrahen.application.api.TideApiResponse;
import com.shawncrahen.application.api.tide.TidePredictions;
import com.shawncrahen.application.data.CalculatedNextTide;
import com.shawncrahen.application.task.scheduled.ScheduledTidePredictionsApiUpdater;
import com.shawncrahen.application.utility.DateTimeFormatUtility;

@Service
public class NextTideService {

  ScheduledTidePredictionsApiUpdater scheduledTideApiUpdater;

  private NextTideService(ScheduledTidePredictionsApiUpdater scheduleTideApiUpdater) {
    this.scheduledTideApiUpdater = scheduleTideApiUpdater;
  }

  public CalculatedNextTide getNextTide() {
    TideApiResponse tideApiResponse = scheduledTideApiUpdater.getTideApiResponse();
    TidePredictions[] predictions = tideApiResponse.getPredictions();

    ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
    int i = 0;
    while (now.compareTo(predictions[i].getDateTime()) > 0) {
      i++;
    }
    return new CalculatedNextTide(
            predictions[i].getDateTime().format(DateTimeFormatUtility.getTimeOnlyFormatter()),
            predictions[i].getType());
  }

}
