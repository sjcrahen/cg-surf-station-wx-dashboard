package com.shawncrahen.application.rest.weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Astro {

  private String sunrise;
  private String sunset;

  public Astro() {}

  public String getSunrise() {
    return sunrise;
  }

  public void setSunrise(String sunrise) throws ParseException {
    SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
    SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
    Date date = parseFormat.parse(sunrise);
    this.sunrise = displayFormat.format(date);
  }

  public String getSunset() {
    return sunset;
  }

  public void setSunset(String sunset) throws ParseException {
    SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
    SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
    Date date = parseFormat.parse(sunset);
    this.sunset = displayFormat.format(date);
  }

  @Override
  public String toString() {
    return "{\n  \"Astro\": {\n    \"sunrise\":\"" + sunrise + "\", \n    \"sunset\":\"" + sunset
            + "\"\n  }\n}";
  }
}
