package com.shawncrahen.application.rest.current;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

}
