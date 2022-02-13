package com.shawncrahen.application.data;

import org.springframework.stereotype.Component;

@Component
public class ActiveStation {

  private String stationId;

  private ActiveStation() {}

  public String getName() {
    return stationId;
  }

  public void setName(String name) {
    this.stationId = name;
  }

  @Override
  public String toString() {
    return "{\n  \"ActiveStation\": {\n    \"name\":\"" + stationId + "\"\n  }\n}";
  }

}
