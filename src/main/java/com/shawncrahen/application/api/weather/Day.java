package com.shawncrahen.application.api.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

  private int maxtemp_f;
  private int mintemp_f;

  private Day() {}

  public double getMaxtemp_f() {
    return maxtemp_f;
  }

  public void setMaxtemp_f(int maxtemp_f) {
    this.maxtemp_f = maxtemp_f;
  }

  public double getMintemp_f() {
    return mintemp_f;
  }

  public void setMintemp_f(int mintemp_f) {
    this.mintemp_f = mintemp_f;
  }

  @Override
  public String toString() {
    return "{\n  \"Day\": {\n    \"maxtemp_f\":\"" + maxtemp_f + "\", \n    \"mintemp_f\":\""
            + mintemp_f + "\"\n  }\n}";
  }

}
