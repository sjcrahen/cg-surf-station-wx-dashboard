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
import com.shawncrahen.application.data.SeasObservation;
import com.shawncrahen.application.utility.DateFormatUtility;

@Component
public class ScheduledSeasObservationUpdater {

  private SeasObservation seasObservation;

  public ScheduledSeasObservationUpdater(SeasObservation seasObservation) {
    this.seasObservation = seasObservation;
  }

  public SeasObservation getSeasObservation() {
    return seasObservation;
  }

  public void setSeasObservation(SeasObservation seasObservation) {
    this.seasObservation = seasObservation;
  }

  @Scheduled(fixedRate = 300000)
  private void updateSeasObservation() {
    String url = "https://www.ndbc.noaa.gov/data/realtime2/44098.txt";
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
      String waveHeight = data[8];
      String dominantPeriod = data[9];
      String waveDirection = data[11];
      ZonedDateTime zuluTime =
              ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, minute), ZoneId.of("Z"));
      seasObservation.setDateTime(zuluTime.withZoneSameInstant(ZoneId.of("America/New_York")));
      seasObservation.setDateTimeString(
              seasObservation.getDateTime().format(DateFormatUtility.getFormatter()));
      seasObservation
              .setWaveHeight(String.format("%.1f", (Double.parseDouble(waveHeight) * 3.28084)));
      seasObservation
              .setDominantPeriod(String.format("%.1f", (Double.parseDouble(dominantPeriod))));
      seasObservation.setWaveDirection(
              String.format("%03d", (Integer.parseInt(waveDirection))));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
