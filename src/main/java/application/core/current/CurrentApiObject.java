package application.core.current;

public class CurrentApiObject {

  private CurrentPredictions current_predictions;

  public CurrentApiObject() {}

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
