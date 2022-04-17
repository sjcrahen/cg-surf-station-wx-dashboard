package com.shawncrahen.application.rest.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

  private int maxtemp_f;
  private int mintemp_f;
  private int maxwind_mph;
  private Condition condition;
  private int daily_chance_of_rain;
  private int daily_chance_of_snow;
  private int chance_of_precip;

  private Day() {}

  public int getMaxtemp_f() {
    return maxtemp_f;
  }

  public void setMaxtemp_f(double maxtemp_f) {
    this.maxtemp_f = (int) Math.round(maxtemp_f);
  }

  public int getMintemp_f() {
    return mintemp_f;
  }

  public void setMintemp_f(double mintemp_f) {
    this.mintemp_f = (int) Math.round(mintemp_f);
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public int getMaxwind_mph() {
    return maxwind_mph;
  }

  public void setMaxwind_mph(double maxwind_mph) {
    this.maxwind_mph = (int) Math.round(maxwind_mph);
  }

  public int getDaily_chance_of_rain() {
    return daily_chance_of_rain;
  }

  public void setDaily_chance_of_rain(int daily_chance_of_rain) {
    this.daily_chance_of_rain = daily_chance_of_rain;
  }

  public int getDaily_chance_of_snow() {
    return daily_chance_of_snow;
  }

  public void setDaily_chance_of_snow(int daily_chance_of_snow) {
    this.daily_chance_of_snow = daily_chance_of_snow;
  }

  public int getChance_of_precip() {
    return chance_of_precip;
  }

  public void setChance_of_precip() {
    this.chance_of_precip = Math.max(daily_chance_of_rain, daily_chance_of_snow);
  }

  @Override
  public String toString() {
    return "{\n  \"Day\": {\n    \"maxtemp_f\":\"" + maxtemp_f + "\", \n    \"mintemp_f\":\""
            + mintemp_f + "\", \n    \"maxwind_mph\":\"" + maxwind_mph
            + "\", \n    \"condition\":\"" + condition + "\", \n    \"chance_of_precip\":\""
            + chance_of_precip + "\"\n  }\n}";
  }

}
