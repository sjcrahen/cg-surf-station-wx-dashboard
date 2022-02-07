package com.shawncrahen.application.rest.current;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shawncrahen.application.data.PresentCurrent;
import com.shawncrahen.application.utility.DateFormatUtility;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentPredictions {

  @JsonProperty("cp")
  private CurrentPrediction[] predictions;

  public CurrentPredictions() {}


  public CurrentPrediction[] getPredictions() {
    return predictions;
  }

  public void setPredictions(CurrentPrediction[] predictions) {
    this.predictions = predictions;
  }

  public PresentCurrent calculatePresentCurrent() {
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
    Duration timeDiff = Duration.between(first.getDateTime(), last.getDateTime());
    Duration diffFromNow = Duration.between(first.getDateTime(), now);

    double firstVelocity = Double.parseDouble(first.getVelocity());
    double lastVelocity = Double.parseDouble(last.getVelocity());
    double velocityDiff = lastVelocity - firstVelocity;
    double velocityRateOfChange = velocityDiff / timeDiff.toMinutes();
    double presentCurrent = firstVelocity + (diffFromNow.toMinutes() * velocityRateOfChange);

    return new PresentCurrent(now.format(DateFormatUtility.getFormatter()), presentCurrent);
  }
}
