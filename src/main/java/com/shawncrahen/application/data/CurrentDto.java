package com.shawncrahen.application.data;

import com.shawncrahen.application.data.current.CurrentPredictions;

public class CurrentDto {

  private CurrentPredictions current_predictions;

  public CurrentDto() {}

  public CurrentPredictions getCurrent_predictions() {
    return current_predictions;
  }

  public void setCurrent_predictions(CurrentPredictions current_predictions) {
    this.current_predictions = current_predictions;
  }

  public void reset() {
    current_predictions = null;
  }

  @Override
  public String toString() {
    return "{\n  \"CurrentPredictionResponse\": {\n    \"current_predictions\":\""
            + current_predictions + "\"\n  }\n}";
  }

}
