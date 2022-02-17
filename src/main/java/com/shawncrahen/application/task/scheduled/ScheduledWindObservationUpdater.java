package com.shawncrahen.application.task.scheduled;

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
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;
import com.shawncrahen.application.utility.DateTimeFormatUtility;

@Component
public class ScheduledWindObservationUpdater implements ScheduledUpdater {

  private StationService stationService;
  private WindObservation windObservation;

  private ScheduledWindObservationUpdater(StationService stationService,
          WindObservation windObservation) {
    this.stationService = stationService;
    this.windObservation = windObservation;
  }

  public WindObservation getWindObservation() {
    return windObservation;
  }

  public void setWindObservation(WindObservation windObservation) {
    this.windObservation = windObservation;
  }

  @Override
  @Scheduled(fixedRate = 180000)
  public void update() {
    Station station = stationService.getStation();
    if (station != null && station.getWindSourceId() == null) {
      windObservation.reset();
    }
    if (station != null && station.getWindSourceId() != null) {
      String url = "https://www.ndbc.noaa.gov/data/realtime2/"
              + station.getWindSourceId()
              + ".txt";
      try (BufferedReader in =
              new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
        String dataLine = "";
        String[] data = null;
        for (int lineNumber = 0; lineNumber < 8; lineNumber++) {
          String line = in.readLine();
          if (lineNumber == 2) {
            dataLine = line;
            data = dataLine.split("[ ]+");
            if (!data[6].equals("MM")) {
              break;
            }

          }
        }
        if (data != null) {
          int year = Integer.parseInt(data[0]);
          int month = Integer.parseInt(data[1]);
          int day = Integer.parseInt(data[2]);
          int hour = Integer.parseInt(data[3]);
          int minute = Integer.parseInt(data[4]);
          String windDirection = data[5];
          double windSpeed = Double.parseDouble(data[6]);
          double windGust = Double.parseDouble(data[7]);
          ZonedDateTime zuluTime =
                  ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, minute),
                          ZoneId.of("Z"));
          windObservation
                  .setDateTime(zuluTime.withZoneSameInstant(ZoneId.of(station.getTimeZone())));
          windObservation.setDateTimeString(
                  windObservation.getDateTime()
                          .format(DateTimeFormatUtility.getTimeOnlyFormatter()));
          windObservation.setWindDirection(windDirection.equals("MM") ? "---"
                  : String.format("%3d", (Math.round(Double.parseDouble(windDirection) / 5)) * 5)
                          .replace(' ', '0'));
          windObservation.setDirection(Math.round(Double.parseDouble(windDirection) / 5) * 5);
          windObservation.setWindSpeed((int) Math.round(windSpeed * 1.94384));
          windObservation.setWindGust((int) Math.round(windGust * 1.94384));
        }
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
