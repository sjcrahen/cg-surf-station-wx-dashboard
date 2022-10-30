package application.core.weather;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

  @JsonProperty("forecastday")
  private ForecastDay[] forecastDay;

  private Forecast() {}

  public ForecastDay[] getForecastDay() {
    return forecastDay;
  }

  public void setForecastDay(ForecastDay[] forecastDay) {
    this.forecastDay = forecastDay;
  }

  @Override
  public String toString() {
    return "{\n  \"Forecast\": {\n    \"forecastDay\":\"" + Arrays.toString(forecastDay)
            + "\"\n  }\n}";
  }

}
