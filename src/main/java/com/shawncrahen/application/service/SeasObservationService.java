package com.shawncrahen.application.service;

import org.springframework.stereotype.Service;
import com.shawncrahen.application.data.SeasObservation;
import com.shawncrahen.application.task.ScheduledSeasObservationUpdater;

@Service
public class SeasObservationService {

  private ScheduledSeasObservationUpdater seasObservationUpdater;

  public SeasObservationService(ScheduledSeasObservationUpdater seasObservationUpdater) {
    this.seasObservationUpdater = seasObservationUpdater;
  }

  public SeasObservation getSeasObservation() {
    return seasObservationUpdater.getSeasObservation();
  }
}
