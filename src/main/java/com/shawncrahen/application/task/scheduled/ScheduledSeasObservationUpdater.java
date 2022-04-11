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
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.shawncrahen.application.data.SeasObservation;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.StationService;

@Component
@Scope("session")
public class ScheduledSeasObservationUpdater implements ScheduledUpdater {

  private StationService stationService;
  private SeasObservation seasObservation;
  private SeasObservation seasObservation2;

  public ScheduledSeasObservationUpdater(StationService stationService,
          SeasObservation seasObservation, SeasObservation seasObservation2) {
    this.stationService = stationService;
    this.seasObservation = seasObservation;
    this.seasObservation2 = seasObservation2;
  }

  public SeasObservation getSeasObservation() {
    return seasObservation;
  }

  public void setSeasObservation(SeasObservation seasObservation) {
    this.seasObservation = seasObservation;
  }

  public SeasObservation getSeasObservation2() {
    return seasObservation2;
  }

  public void setSeasObservation2(SeasObservation seasObservation2) {
    this.seasObservation2 = seasObservation2;
  }

  @Override
  @Scheduled(fixedRate = 180000)
  public void update() {
    Station station = stationService.getStation();
    if (station != null) {
      updateObservation(station, station.getWaveSourceId(), seasObservation);
      updateObservation(station, station.getWaveSourceId2(), seasObservation2);
    }
  }

  private static void updateObservation(Station station, String sourceId, SeasObservation ob) {
    if (sourceId == null) {
      return;
    }
    String url = "https://www.ndbc.noaa.gov/data/realtime2/"
            + sourceId
            + ".txt";
    try (BufferedReader in =
            new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
      String dataLine = "";
      String[] data = null;
      for (int lineNumber = 0; lineNumber < 8; lineNumber++) {
        String line = in.readLine();
        if (lineNumber >= 2) {
          dataLine = line;
          data = dataLine.split("[ ]+");
          if (!data[9].equals("MM")) {
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
        String waveHeight = data[8];
        String dominantPeriod = data[9];
        String waveDirection = data[11];
        ZonedDateTime zuluTime =
                ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, minute),
                        ZoneId.of("Z"));
        ZonedDateTime observationTime =
                zuluTime.withZoneSameInstant(ZoneId.of(station.getTimeZone()));
        ob.setDateTime(observationTime);
        ob.setDateTimeString(ob.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        ob.setWaveHeight(String.format("%.1f", (Double.parseDouble(waveHeight) * 3.28084)));
        ob.setDominantPeriod(dominantPeriod);
        if (waveDirection.equals("MM")) {
          ob.setWaveDirection(null);
        } else {
          ob.setWaveDirection(
                  String.valueOf(Math.round(Double.parseDouble(waveDirection) / 5) * 5));
          ob.setDirection(Math.round(Double.parseDouble(waveDirection) / 5) * 5);
        }
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(station.getTimeZone()));
        if (now.minusHours(4).compareTo(observationTime) > 0) {
          ob.setOutDated(true);
        } else {
          ob.setOutDated(false);
        }
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
