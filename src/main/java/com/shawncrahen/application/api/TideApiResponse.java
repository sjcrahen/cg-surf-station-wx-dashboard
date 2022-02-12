package com.shawncrahen.application.api;

import java.util.Arrays;
import com.shawncrahen.application.api.tide.TidePredictions;

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
