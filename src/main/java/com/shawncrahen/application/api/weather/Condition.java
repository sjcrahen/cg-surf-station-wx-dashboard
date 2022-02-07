package com.shawncrahen.application.api.weather;

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


}
