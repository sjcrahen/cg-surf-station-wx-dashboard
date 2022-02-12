package com.shawncrahen.application.utility;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatUtility {

  private static DateTimeFormatter complexFormatter =
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  private static DateTimeFormatter timeOnlyFormatter = DateTimeFormatter.ofPattern("HH:mm");

  private DateTimeFormatUtility() {}

  public static DateTimeFormatter getComplexFormatter() {
    return complexFormatter;
  }

  public static void setComplexFormatter(DateTimeFormatter complexFormatter) {
    DateTimeFormatUtility.complexFormatter = complexFormatter;
  }

  public static DateTimeFormatter getTimeOnlyFormatter() {
    return timeOnlyFormatter;
  }

  public static void setTimeOnlyFormatter(DateTimeFormatter timeOnlyFormatter) {
    DateTimeFormatUtility.timeOnlyFormatter = timeOnlyFormatter;
  }

}
