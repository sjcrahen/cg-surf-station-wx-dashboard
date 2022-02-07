package com.shawncrahen.application.service;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Service;
import com.shawncrahen.application.api.CurrentApiResponse;
import com.shawncrahen.application.api.current.CurrentPrediction;
import com.shawncrahen.application.data.CalculatedPresentCurrent;
import com.shawncrahen.application.task.ScheduledCurrentPredictionsApiUpdater;
import com.shawncrahen.application.utility.DateFormatUtility;

@Service
public class CalculatedPresentCurrentService {

  private ScheduledCurrentPredictionsApiUpdater scheduledCurrentPredictionsUpdater;

  private CalculatedPresentCurrentService(
          ScheduledCurrentPredictionsApiUpdater scheduledCurrentPredictionsUpdater) {
    this.scheduledCurrentPredictionsUpdater = scheduledCurrentPredictionsUpdater;
  }

  public CalculatedPresentCurrent getCalculatedPresentCurrent() {
    CurrentApiResponse currentApiResponse =
            scheduledCurrentPredictionsUpdater.getCurrentApiResponse();
    CurrentPrediction[] predictions = currentApiResponse.getCurrent_predictions().getPredictions();
    for (CurrentPrediction prediction : predictions) {
      prediction.setDateTime(prediction.getTime());
    }

    ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
    int i = 0;
    while (now.compareTo(predictions[i].getDateTime()) > 0) {
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

    return new CalculatedPresentCurrent(now.format(DateFormatUtility.getFormatter()),
            presentCurrent);
  }

}
