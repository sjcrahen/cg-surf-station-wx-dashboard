package com.shawncrahen.application.data;

import java.util.Arrays;
import com.shawncrahen.application.data.tide.TidePredictions;

public class TideDto {

  private TidePredictions[] predictions;

  private TideDto() {}

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
