package com.shawncrahen.application.task;

import org.springframework.stereotype.Component;
import com.shawncrahen.application.task.scheduled.ScheduledCurrentPredictionsUpdater;
import com.shawncrahen.application.task.scheduled.ScheduledSeasObservationUpdater;
import com.shawncrahen.application.task.scheduled.ScheduledTidePredictionsUpdater;
import com.shawncrahen.application.task.scheduled.ScheduledWeatherUpdater;
import com.shawncrahen.application.task.scheduled.ScheduledWindObservationUpdater;

@Component
public class ApiUpdater {

  private ScheduledCurrentPredictionsUpdater currentUpdater;
  private ScheduledSeasObservationUpdater seasUpdater;
  private ScheduledTidePredictionsUpdater tideUpdater;
  private ScheduledWeatherUpdater weatherUpdater;
  private ScheduledWindObservationUpdater windUpdater;

  private ApiUpdater(ScheduledCurrentPredictionsUpdater currentUpdater,
          ScheduledSeasObservationUpdater seasUpdater,
          ScheduledTidePredictionsUpdater tideUpdater, ScheduledWeatherUpdater weatherUpdater,
          ScheduledWindObservationUpdater windUpdater) {
    this.currentUpdater = currentUpdater;
    this.seasUpdater = seasUpdater;
    this.tideUpdater = tideUpdater;
    this.weatherUpdater = weatherUpdater;
    this.windUpdater = windUpdater;
  }

  public void refreshAll() {
    currentUpdater.update();
    seasUpdater.update();
    tideUpdater.update();
    weatherUpdater.update();
    windUpdater.update();
  }

}
