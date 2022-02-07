package com.shawncrahen.application.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.shawncrahen.application.data.WindObservation;
import com.shawncrahen.application.utility.DateFormatUtility;

@Component
public class ScheduledWindObservationUpdater {

  private WindObservation windObservation;

  public ScheduledWindObservationUpdater(WindObservation windObservation) {
    this.windObservation = windObservation;
  }

  public WindObservation getWindObservation() {
    return windObservation;
  }

  public void setWindObservation(WindObservation windObservation) {
    this.windObservation = windObservation;
  }

  @Scheduled(fixedRate = 300000)
  private void updateWindData() {
    String url = "https://www.ndbc.noaa.gov/data/realtime2/IOSN3.txt";
    try (BufferedReader in =
            new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
      String dataLine = "";
      for (int lineNumber = 0; lineNumber < 3; lineNumber++) {
        String line = in.readLine();
        if (lineNumber == 2) {
          dataLine = line;
        }
      }
      String[] data = dataLine.split("[ ]+");
      int year = Integer.parseInt(data[0]);
      int month = Integer.parseInt(data[1]);
      int day = Integer.parseInt(data[2]);
      int hour = Integer.parseInt(data[3]);
      int minute = Integer.parseInt(data[4]);
      String windDirection = data[5];
      double windSpeed = Double.parseDouble(data[6]);
      double windGust = Double.parseDouble(data[7]);
      ZonedDateTime zuluTime =
              ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, minute), ZoneId.of("Z"));
      windObservation.setDateTime(zuluTime.withZoneSameInstant(ZoneId.of("America/New_York")));
      windObservation.setDateTimeString(
              windObservation.getDateTime().format(DateFormatUtility.getFormatter()));
      windObservation.setWindDirection(String.format("%3s", windDirection).replace(' ', '0'));
      windObservation.setWindSpeed((int) Math.round(windSpeed * 1.94384));
      windObservation.setWindGust((int) Math.round(windGust * 1.94384));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
