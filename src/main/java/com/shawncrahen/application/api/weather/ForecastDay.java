package com.shawncrahen.application.api.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {

  private Day day;
  private Astro astro;

  private ForecastDay() {}

  public Day getDay() {
    return day;
  }

  public void setDay(Day day) {
    this.day = day;
  }

  public Astro getAstro() {
    return astro;
  }

  public void setAstro(Astro astro) {
    this.astro = astro;
  }

  @Override
  public String toString() {
    return "{\n  \"ForecastDay\": {\n    \"day\":\"" + day + "\", \n    \"astro\":\"" + astro
            + "\"\n  }\n}";
  }


}
