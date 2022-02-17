package com.shawncrahen.application.data.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition {

  private String text;
  private String icon;

  private Condition() {}

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  @Override
  public String toString() {
    return "{\n  \"Condition\": {\n    \"text\":\"" + text + "\", \n    \"icon\":\"" + icon
            + "\"\n  }\n}";
  }


}
