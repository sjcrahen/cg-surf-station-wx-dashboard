package com.shawncrahen.application.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.SeasObservation;
import com.shawncrahen.application.task.scheduled.ScheduledSeasObservationUpdater;

@Service
@Scope("session")
public class SeasObservationService {

  private ScheduledSeasObservationUpdater seasObservationUpdater;

  public SeasObservationService(ScheduledSeasObservationUpdater seasObservationUpdater) {
    this.seasObservationUpdater = seasObservationUpdater;
  }

  public SeasObservation getSeasObservation() {
    return seasObservationUpdater.getSeasObservation();
  }

  public SeasObservation getSeasObservation2() {
    return seasObservationUpdater.getSeasObservation2();
  }

}
