package com.shawncrahen.application.data;

public class PresentCurrent {

  private String dateTimeString;
  private String type;
  private String velocity;

  public PresentCurrent(String dateTimeString, double velocity) {
    this.dateTimeString = dateTimeString;
    if (velocity < -0.05) {
      this.type = "Ebb";
    } else if (velocity > 0.049) {
      this.type = "Flood";
    } else {
      this.type = "Slack";
    }
    this.velocity = String.format("%.1f", Math.abs(velocity));
  }

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
    this.velocity = velocity;
  }

  public String getDateTimeString() {
    return dateTimeString;
  }

  public void setDateTimeString(String dateTimeString) {
    this.dateTimeString = dateTimeString;
  }

  @Override
  public String toString() {
    return "{\n  \"PresentCurrent\": {\n    \"type\":\"" + type + "\", \n    \"velocity\":\""
            + velocity + "\"\n  }\n}";
  }

}
