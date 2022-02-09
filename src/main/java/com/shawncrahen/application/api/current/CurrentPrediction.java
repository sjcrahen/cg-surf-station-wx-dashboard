package com.shawncrahen.application.api.current;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentPrediction {

  private ZonedDateTime dateTime;

  @JsonProperty("Type")
  private String type;

  @JsonProperty("Time")
  private String time;

  @JsonProperty("Velocity_Major")
  private String velocity;

  private String meanFloodDir;

  private String meanEbbDir;

  public CurrentPrediction() {}

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getVelocity() {
    return velocity;
  }

  public void setVelocity(String velocity) {
    this.velocity = String.format("%.1f", Double.parseDouble(velocity));
  }

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

  public String getMeanFloodDir() {
    return meanFloodDir;
  }

  public void setMeanFloodDir(String meanFloodDir) {
    this.meanFloodDir = meanFloodDir;
  }

  public String getMeanEbbDir() {
    return meanEbbDir;
  }

  public void setMeanEbbDir(String meanEbbDir) {
    this.meanEbbDir = meanEbbDir;
  }

  @Override
  public String toString() {
    return "{\n  \"CurrentPrediction\": {\n    \"dateTime\":\"" + dateTime + "\", \n    \"type\":\""
            + type + "\", \n    \"velocity\":\"" + velocity + "\", \n    \"meanFloodDir\":\""
            + meanFloodDir + "\", \n    \"meanEbbDir\":\"" + meanEbbDir + "\"\n  }\n}";
  }

}
