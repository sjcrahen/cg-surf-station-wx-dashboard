package com.shawncrahen.application.service;

import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.WindObservation;
import com.shawncrahen.application.task.scheduled.ScheduledWindObservationUpdater;

@Service
public class WindObservationService {

  private ScheduledWindObservationUpdater windObservationUpdater;

  public WindObservationService(ScheduledWindObservationUpdater windObservationUpdater) {
    this.windObservationUpdater = windObservationUpdater;
  }

  public WindObservation getWindObservation() {
    return windObservationUpdater.getWindObservation();
  }
}
