package com.shawncrahen.application.api.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {

  private String date;
  private Day day;
  private Astro astro;

  private ForecastDay() {}

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

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
    return "{\n  \"ForecastDay\": {\n    \"date\":\"" + date + "\", \n    \"day\":\"" + day
            + "\", \n    \"astro\":\"" + astro + "\"\n  }\n}";
  }


}
