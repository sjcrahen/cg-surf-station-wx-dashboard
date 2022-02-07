package com.shawncrahen.application.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shawncrahen.application.data.WaveData;
import com.shawncrahen.application.data.WindData;
import com.shawncrahen.application.rest.CurrentApiResponse;
import com.shawncrahen.application.rest.WeatherApiResponse;
import com.shawncrahen.application.utility.DateFormatUtility;

@Component
public class ScheduledTasks {

  @Autowired
  private WindData windData;

  @Autowired
  private WaveData waveData;

  @Autowired
  private RestTemplate restTemplate;

  private CurrentApiResponse currentApiResponse;
  private WeatherApiResponse weatherApiResponse;

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
      windData.setDateTime(zuluTime.withZoneSameInstant(ZoneId.of("America/New_York")));
      windData.setDateTimeString(windData.getDateTime().format(DateFormatUtility.getFormatter()));
      windData.setWindDirection(String.format("%3s", windDirection).replace(' ', '0'));
      windData.setWindSpeed((int) Math.round(windSpeed * 1.94384));
      windData.setWindGust((int) Math.round(windGust * 1.94384));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Scheduled(fixedRate = 300000)
  private void updateWaveData() {
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
      waveData.setDateTime(zuluTime.withZoneSameInstant(ZoneId.of("America/New_York")));
      waveData.setDateTimeString(waveData.getDateTime().format(DateFormatUtility.getFormatter()));
      waveData.setWaveHeight(String.format("%.1f", (Double.parseDouble(waveHeight) * 3.28084)));
      waveData.setDominantPeriod(String.format("%.1f", (Double.parseDouble(dominantPeriod))));
      waveData.setWaveDirection(
              String.format("%03d", (Integer.parseInt(waveDirection))));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Scheduled(fixedRate = 43200000)
  private void updateCurrentPrediction() {
    String todayString = LocalDate.now().toString().replaceAll("-", "");
    currentApiResponse = restTemplate.getForObject(
            "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?station=ACT0816&begin_date="
                    + todayString
                    + "&range=36&product=currents_predictions&units=english&time_zone=lst_ldt&format=json",
            CurrentApiResponse.class);
  }

  public CurrentApiResponse getCurrentApiResponse() {
    return currentApiResponse;
  }

  @Scheduled(fixedRate = 900000)
  private void updateWeather() {
    weatherApiResponse = restTemplate.getForObject(
            "http://api.weatherapi.com/v1/current.json?key=3436a533716643b989d191452220402&q=01950&aqi=no",
            WeatherApiResponse.class);
  }

  public WeatherApiResponse getWeatherApiResponse() {
    return weatherApiResponse;
  }

}
