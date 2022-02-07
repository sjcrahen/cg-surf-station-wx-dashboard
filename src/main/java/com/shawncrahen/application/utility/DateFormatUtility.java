package com.shawncrahen.application.utility;

import java.time.format.DateTimeFormatter;

public class DateFormatUtility {

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private DateFormatUtility() {}

  public static DateTimeFormatter getFormatter() {
    return formatter;
  }

  public void setFormatter(DateTimeFormatter formatter) {
    DateFormatUtility.formatter = formatter;
  }

}
