package com.shawncrahen.application.data;

import org.springframework.stereotype.Component;

@Component
public class ActiveStation {

  private String name;

  public ActiveStation() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "{\n  \"ActiveStation\": {\n    \"name\":\"" + name + "\"\n  }\n}";
  }


}
