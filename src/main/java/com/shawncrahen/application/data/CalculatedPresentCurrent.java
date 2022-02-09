package com.shawncrahen.application.data;

public class CalculatedPresentCurrent {

  private String dateTimeString;
  private String type;
  private String velocity;
  private String direction;

  public CalculatedPresentCurrent(String dateTimeString, double velocity, String ebbDirection,
          String floodDirection) {
    this.dateTimeString = dateTimeString;
    if (velocity < -0.05) {
      this.type = "Ebb";
      direction = ebbDirection;
    } else if (velocity > 0.049) {
      this.type = "Flood";
      direction = floodDirection;
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

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  @Override
  public String toString() {
    return "{\n  \"CalculatedPresentCurrent\": {\n    \"dateTimeString\":\"" + dateTimeString
            + "\", \n    \"type\":\"" + type + "\", \n    \"velocity\":\"" + velocity
            + "\", \n    \"direction\":\"" + direction + "\"\n  }\n}";
  }

}
