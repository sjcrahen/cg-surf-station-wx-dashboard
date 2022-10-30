package application.core.seas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

@Service
public class SeasObservationService {

  public SeasObservation getSeasObservation(String sourceId, String timeZone) {
    SeasObservation ob = new SeasObservation();
    if (sourceId == null) {
      return null;
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
                zuluTime.withZoneSameInstant(ZoneId.of(timeZone));
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
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(timeZone));
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
    return ob;
  }
}
