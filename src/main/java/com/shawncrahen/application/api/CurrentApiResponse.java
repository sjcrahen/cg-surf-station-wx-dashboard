package com.shawncrahen.application.api;

import com.shawncrahen.application.api.current.CurrentPredictions;

public class CurrentApiResponse {

  private CurrentPredictions current_predictions;

  public CurrentApiResponse() {}

  public CurrentPredictions getCurrent_predictions() {
    return current_predictions;
  }

  public void setCurrent_predictions(CurrentPredictions current_predictions) {
    this.current_predictions = current_predictions;
  }

  @Override
  public String toString() {
    return "{\n  \"CurrentPredictionResponse\": {\n    \"current_predictions\":\""
            + current_predictions + "\"\n  }\n}";
  }

}
