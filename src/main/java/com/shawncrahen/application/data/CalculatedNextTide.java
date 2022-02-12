package com.shawncrahen.application.data;

public class CalculatedNextTide {

  private String time;
  private String type;

  public CalculatedNextTide(String time, String type) {
    this.time = time;
    if (type.equals("H")) {
      this.type = "High";
    } else if (type.equals("L")) {
      this.type = "Low";
    }
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "{\n  \"CalculatedNextTide\": {\n    \"time\":\"" + time + "\", \n    \"type\":\"" + type
            + "\"\n  }\n}";
  }

}
