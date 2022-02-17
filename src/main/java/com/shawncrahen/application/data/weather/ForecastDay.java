package com.shawncrahen.application.data.weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

  public void setDate(String date) throws ParseException {
    SimpleDateFormat displayFormat = new SimpleDateFormat("dd MMM");
    SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date theDate = parseFormat.parse(date);
    this.date = displayFormat.format(theDate);

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
