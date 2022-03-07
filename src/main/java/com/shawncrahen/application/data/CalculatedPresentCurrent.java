package com.shawncrahen.application.data;

public class CalculatedPresentCurrent {

  private String dateTimeString;
  private String type;
  private String velocity;
  private String direction;
  private String nextSlackType;
  private String nextSlackTime;

  public CalculatedPresentCurrent(String dateTimeString, double velocity, String ebbDirection,
          String floodDirection, String thisSlackDateTime, String nextSlackDateTime,
          double nextCurrent) {
    this.dateTimeString = dateTimeString;
    if (velocity < -0.049) {
      this.type = "Ebb";
      direction = ebbDirection;
      nextSlackType = "Low";
    } else if (velocity > 0.049) {
      this.type = "Flood";
      direction = floodDirection;
      nextSlackType = "High";
    } else {
      this.type = "Slack";
      nextSlackType = nextCurrent < 0 ? "High" : "Low";
    }
    this.velocity = String.format("%.1f", Math.abs(velocity));
    this.nextSlackTime = Math.abs(velocity) < 0.049 ? thisSlackDateTime : nextSlackDateTime;
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

  public String getNextSlackType() {
    return nextSlackType;
  }

  public void setNextSlackType(String nextSlackType) {
    this.nextSlackType = nextSlackType;
  }

  public String getNextSlackTime() {
    return nextSlackTime;
  }

  public void setNextSlackTime(String nextSlackDateTime) {
    this.nextSlackTime = nextSlackDateTime;
  }

  @Override
  public String toString() {
    return "{\n  \"CalculatedPresentCurrent\": {\n    \"dateTimeString\":\"" + dateTimeString
            + "\", \n    \"type\":\"" + type + "\", \n    \"velocity\":\"" + velocity
            + "\", \n    \"direction\":\"" + direction + "\", \n    \"nextSlack\":\""
            + nextSlackType
            + "\", \n    \"nextSlackDateTime\":\"" + nextSlackTime + "\"\n  }\n}";
  }

}
