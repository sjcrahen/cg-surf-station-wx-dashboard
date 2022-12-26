package application.core.ndbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import application.core.station.StationDto;

@Service
public class NdbcService {

    Logger log = LoggerFactory.getLogger(NdbcService.class);

    public Object[] getCombinedSeasAndWindObservations(StationDto station) {
        String sourceId = station.getWaveSourceId();
        String timeZone = station.getTimeZone();
        Object[] observations = {null, null};

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
                    if (observations[1] == null && !data[6].equals("MM")) {
                        observations[1] = parseWindObservation(data, timeZone);
                    }
                    if (observations[0] == null && !data[9].equals("MM")) {
                        observations[0] = parseSeasObservation(data, timeZone);
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return observations;
    }

    public SeasObservation getSeasObservation(String sourceId, String timeZone) {
        SeasObservation seasObservation = null;
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
                    if (seasObservation == null && !data[9].equals("MM")) {
                        seasObservation = parseSeasObservation(data, timeZone);
                    }
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return seasObservation;
    }

    public WindObservation getWindObservation(StationDto station) {
        String sourceId = station.getWindSourceId();
        String timeZone = station.getTimeZone();

        if (sourceId == null) {
            return null;
        }
        WindObservation windObservation = null;
        String url = "https://www.ndbc.noaa.gov/data/realtime2/"
                        + sourceId
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
                    if (windObservation == null && !data[6].equals("MM")) {
                        windObservation = parseWindObservation(data, timeZone);
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            windObservation = null;
            e.printStackTrace();
        }
        return windObservation;
    }

    private static SeasObservation parseSeasObservation(String[] data, String timeZone) {
        SeasObservation seasObservation = new SeasObservation();

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
            ZonedDateTime seasObservationservationTime =
                            zuluTime.withZoneSameInstant(ZoneId.of(timeZone));

            seasObservation.setDateTime(seasObservationservationTime);
            seasObservation.setDateTimeString(seasObservation.getDateTime()
                            .format(DateTimeFormatter.ofPattern("HH:mm")));

            try {
                seasObservation.setWaveHeight(String.format("%.1f",
                                (Double.parseDouble(waveHeight) * 3.28084)));
            } catch (NumberFormatException ex) {
                return null;
            }

            seasObservation.setDominantPeriod(dominantPeriod);

            try {
                seasObservation.setWaveDirection(
                                String.valueOf(Math.round(Double.parseDouble(waveDirection) / 5)
                                                * 5));
                seasObservation.setDirection(
                                Math.round(Double.parseDouble(waveDirection) / 5) * 5);
            } catch (NumberFormatException ex) {
                seasObservation.setWaveDirection(null);
            }

            ZonedDateTime now = ZonedDateTime.now(ZoneId.of(timeZone));

            if (now.minusHours(4).compareTo(seasObservationservationTime) > 0) {
                seasObservation.setOutDated(true);
            } else {
                seasObservation.setOutDated(false);
            }
        }

        return seasObservation;
    }

    private static WindObservation parseWindObservation(String[] data, String timeZone) {
        WindObservation windObservation = new WindObservation();

        if (data != null) {
            int year = Integer.parseInt(data[0]);
            int month = Integer.parseInt(data[1]);
            int day = Integer.parseInt(data[2]);
            int hour = Integer.parseInt(data[3]);
            int minute = Integer.parseInt(data[4]);
            double windSpeed = -1;
            double windGust = -1;

            String windDirection = data[5].equals("MM") ? "-1" : data[5];

            try {
                windSpeed = Double.parseDouble(data[6]);
            } catch (NumberFormatException ex) {
                return null;
            }

            try {
                windGust = Double.parseDouble(data[7]);
            } catch (NumberFormatException ex) {
                // fall through
            }

            ZonedDateTime zuluTime =
                            ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, minute),
                                            ZoneId.of("Z"));
            ZonedDateTime seasObservationservationTime =
                            zuluTime.withZoneSameInstant(ZoneId.of(timeZone));
            windObservation.setDateTime(seasObservationservationTime);
            windObservation.setDateTimeString(
                            windObservation.getDateTime()
                                            .format(DateTimeFormatter.ofPattern("HH:mm")));
            windObservation.setWindDirection(windDirection.equals("-1") ? null
                            : String.format("%3d",
                                            (Math.round(Double.parseDouble(windDirection) / 5)) * 5)
                                            .replace(' ', '0'));
            if (windObservation.getWindDirection() != null) {
                windObservation.setDirection(
                                Math.round(Double.parseDouble(windDirection) / 5) * 5);
            } else {
                windObservation.setDirection(-1);
            }

            if (windSpeed >= 0) {
                windObservation.setWindSpeed((int) Math.round(windSpeed * 1.94384));
            } else {
                windObservation.setWindSpeed(-1);
            }

            if (windGust >= 0) {
                windObservation.setWindGust((int) Math.round(windGust * 1.94384));
            } else {
                windObservation.setWindGust(-1);
            }

            ZonedDateTime now = ZonedDateTime.now(ZoneId.of(timeZone));
            if (now.minusHours(4).compareTo(seasObservationservationTime) > 0) {
                windObservation.setOutDated(true);
            } else {
                windObservation.setOutDated(false);
            }
        }

        return windObservation;
    }
}
