package com.shawncrahen.application.api.tide;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TidePredictions {

  private ZonedDateTime dateTime;

  @JsonProperty("t")
  private String time;

  @JsonProperty("v")
  private String height;

  private String type;

  private TidePredictions() {}

  public ZonedDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    String timeString = dateTime.replace(' ', 'T') + ":00-05:00[America/New_York]";
    ZonedDateTime dt = ZonedDateTime.parse(timeString);
    this.dateTime = dt;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
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
