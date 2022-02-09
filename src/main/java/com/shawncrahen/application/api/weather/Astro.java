package com.shawncrahen.application.api.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Astro {

  private String sunrise;
  private String sunset;

  private Astro() {}

  public String getSunrise() {
    return sunrise;
  }

  public void setSunrise(String sunrise) {
    this.sunrise = sunrise;
  }

  public String getSunset() {
    return sunset;
  }

  public void setSunset(String sunset) {
    this.sunset = sunset;
  }

  @Override
  public String toString() {
    return "{\n  \"Astro\": {\n    \"sunrise\":\"" + sunrise + "\", \n    \"sunset\":\"" + sunset
            + "\"\n  }\n}";
  }


}
