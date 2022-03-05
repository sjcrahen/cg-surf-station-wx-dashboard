package com.shawncrahen.application.data;

public class CalculatedNextTide {

  private String time;
  private String type;
  private String height;

  public CalculatedNextTide(String time, String type, String height) {
    this.time = time;
    if (type.equals("H")) {
      this.type = "High";
    } else if (type.equals("L")) {
      this.type = "Low";
    }
    this.height = String.format("%.1f", (Double.parseDouble(height)));
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

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = String.format("%.1f", (Double.parseDouble(height)));
  }

  @Override
  public String toString() {
    return "{\n  \"CalculatedNextTide\": {\n    \"time\":\"" + time + "\", \n    \"type\":\"" + type
            + "\", \n    \"height\":\"" + height + "\"\n  }\n}";
  }

}
