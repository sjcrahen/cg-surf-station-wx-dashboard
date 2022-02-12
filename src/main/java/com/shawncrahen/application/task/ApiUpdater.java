package com.shawncrahen.application.task;

import org.springframework.stereotype.Component;
import com.shawncrahen.application.task.scheduled.ScheduledCurrentPredictionsApiUpdater;
import com.shawncrahen.application.task.scheduled.ScheduledSeasObservationUpdater;
import com.shawncrahen.application.task.scheduled.ScheduledTidePredictionsApiUpdater;
import com.shawncrahen.application.task.scheduled.ScheduledWeatherApiUpdater;
import com.shawncrahen.application.task.scheduled.ScheduledWindObservationUpdater;

@Component
public class ApiUpdater {

  private ScheduledCurrentPredictionsApiUpdater currentUpdater;
  private ScheduledSeasObservationUpdater seasUpdater;
  private ScheduledTidePredictionsApiUpdater tideUpdater;
  private ScheduledWeatherApiUpdater weatherUpdater;
  private ScheduledWindObservationUpdater windUpdater;

  private ApiUpdater(ScheduledCurrentPredictionsApiUpdater currentUpdater,
          ScheduledSeasObservationUpdater seasUpdater,
          ScheduledTidePredictionsApiUpdater tideUpdater, ScheduledWeatherApiUpdater weatherUpdater,
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
