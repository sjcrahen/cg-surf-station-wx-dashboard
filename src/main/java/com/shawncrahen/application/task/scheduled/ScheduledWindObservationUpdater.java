package com.shawncrahen.application.task.scheduled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.shawncrahen.application.data.WindObservation;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;

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
          double windGust = -1;
          if (!data[7].equals("MM")) {
            windGust = Double.parseDouble(data[7]);
          }
          ZonedDateTime zuluTime =
                  ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, minute),
                          ZoneId.of("Z"));
          ZonedDateTime observationTime =
                  zuluTime.withZoneSameInstant(ZoneId.of(station.getTimeZone()));
          windObservation.setDateTime(observationTime);
          windObservation.setDateTimeString(
                  windObservation.getDateTime()
                          .format(DateTimeFormatter.ofPattern("HH:mm")));
          windObservation.setWindDirection(windDirection.equals("MM") ? null
                  : String.format("%3d", (Math.round(Double.parseDouble(windDirection) / 5)) * 5)
                          .replace(' ', '0'));
          if (!windDirection.equals("MM")) {
            windObservation.setDirection(Math.round(Double.parseDouble(windDirection) / 5) * 5);
          } else {
            windObservation.setDirection(-1);
          }
          windObservation.setWindSpeed((int) Math.round(windSpeed * 1.94384));
          windObservation.setWindGust((int) Math.round(windGust * 1.94384));
          ZonedDateTime now = ZonedDateTime.now(ZoneId.of(station.getTimeZone()));
          if (now.minusHours(4).compareTo(observationTime) > 0) {
            windObservation.setOutDated(true);
          } else {
            windObservation.setOutDated(false);
          }
        }
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (IOException e) {
        windObservation = null;
        e.printStackTrace();
      }
    }
  }
}
