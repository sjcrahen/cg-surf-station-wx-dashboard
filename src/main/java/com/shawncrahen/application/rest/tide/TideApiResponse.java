package com.shawncrahen.application.rest.tide;

import java.util.Arrays;

public class TideApiResponse {

  private TidePredictions[] predictions;

  private TideApiResponse() {}

  public TidePredictions[] getPredictions() {
    return predictions;
  }

  public void setPredictions(TidePredictions[] predictions) {
    this.predictions = predictions;
  }

  @Override
  public String toString() {
    return "{\n  \"TideApiResponse\": {\n    \"predictions\":\"" + Arrays.toString(predictions)
            + "\"\n  }\n}";
  }

}
