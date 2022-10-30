package application.core.tide;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TidePredictions {

  private LocalDateTime dateTime;

  @JsonProperty("t")
  private String time;

  @JsonProperty("v")
  private String height;

  private String type;

  private TidePredictions() {}

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
    this.dateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "{\n  \"TidePredictions\": {\n    \"time\":\"" + time + "\", \n    \"height\":\""
            + height + "\", \n    \"type\":\"" + type + "\"\n  }\n}";
  }

}
