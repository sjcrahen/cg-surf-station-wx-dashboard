package com.shawncrahen.application.api.weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Astro {

  private String sunrise;
  private String sunset;

  private Astro() {}

  public String getSunrise() {
    return sunrise;
  }

  public void setSunrise(String sunrise) throws ParseException {
    SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
    SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
    Date date = parseFormat.parse(sunrise);
    this.sunrise = displayFormat.format(date);
    // String[] st = sunrise.substring(0, 5).split(":");
    // if (sunrise.endsWith("PM")) {
    // st[0] = String.valueOf(Integer.parseInt(st[0]) + 12)
    // }
    // LocalTime time = LocalTime.of(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
    // this.sunrise = time.format(DateTimeFormatUtility.getTimeOnlyFormatter());
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
