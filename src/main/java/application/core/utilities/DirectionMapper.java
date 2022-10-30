package application.core.utilities;

public class DirectionMapper {

  public static String mapDirection(long d) {
    if (d >= 0 && d <= 12 || d >= 348)
      return "N";
    if (d >= 13 && d <= 33)
      return "NNE";
    if (d >= 34 && d <= 56)
      return "NE";
    if (d >= 57 && d <= 77)
      return "ENE";
    if (d >= 78 && d <= 102)
      return "E";
    if (d >= 103 && d <= 123)
      return "ESE";
    if (d >= 124 && d <= 146)
      return "SE";
    if (d >= 147 && d <= 167)
      return "SSE";
    if (d >= 168 && d <= 192)
      return "S";
    if (d >= 193 && d <= 213)
      return "SSW";
    if (d >= 214 && d <= 236)
      return "SW";
    if (d >= 237 && d <= 257)
      return "WSW";
    if (d >= 258 && d <= 282)
      return "W";
    if (d >= 283 && d <= 303)
      return "WNW";
    if (d >= 304 && d <= 326)
      return "NW";
    if (d >= 327 && d <= 347)
      return "NNW";
    return "---";
  }
}
