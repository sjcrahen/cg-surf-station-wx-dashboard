package application.core.current;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import application.core.station.StationDto;

@Service
public class CurrentService {

    private RestTemplate restTemplate;

    public CurrentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CalculatedPresentCurrent getCalculatedPresentCurrent(StationDto station,
                    CurrentApiObject currentData) {
        if (station.getCurrentSourceId() == null) {
            return null;
        }

        CurrentPrediction[] predictions =
                        currentData.getCurrent_predictions().getPredictions();
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(station.getTimeZone()));

        int i = 0;
        while (now.compareTo(
                        ZonedDateTime.of(predictions[i].getDateTime(),
                                        ZoneId.of(station.getTimeZone()))) > 0) {
            i++;
        }
        try {
            CurrentPrediction first = predictions[i - 1];
            CurrentPrediction last = predictions[i];
            Duration periodDuration = Duration.between(first.getDateTime(), last.getDateTime());
            Duration diffFromNow = Duration.between(first.getDateTime(), now);

            double firstVelocity = Double.parseDouble(first.getVelocity());
            double lastVelocity = Double.parseDouble(last.getVelocity());
            double velocityChangePerMinute =
                            (lastVelocity - firstVelocity) / periodDuration.toMinutes();
            double presentCurrent =
                            firstVelocity + (diffFromNow.toMinutes() * velocityChangePerMinute);


            CurrentPrediction nextSlackCurrent =
                            Math.abs(Double.parseDouble(first.getVelocity())) < 0.5
                                            ? predictions[i + 1]
                                            : last;
            String nextSlackTime =
                            nextSlackCurrent.getDateTime()
                                            .format(DateTimeFormatter.ofPattern("HH:mm"));
            String thisSlackTime =
                            Math.abs(Double.parseDouble(first.getVelocity())) < 0.5
                                            ? first.getDateTime().format(
                                                            DateTimeFormatter.ofPattern("HH:mm"))
                                            : last.getDateTime().format(
                                                            DateTimeFormatter.ofPattern("HH:mm"));
            return new CalculatedPresentCurrent(now.format(DateTimeFormatter.ofPattern("HH:mm")),
                            presentCurrent, first.getMeanEbbDir(), first.getMeanFloodDir(),
                            thisSlackTime,
                            nextSlackTime, lastVelocity);
        } catch (Exception ex) {
            return null;
        }

    }

    public CurrentApiObject getCurrentData(StationDto station) {
        if (station.getCurrentSourceId() == null) {
            return null;
        }
        String yesterdayString =
                        LocalDate.now(ZoneId.of(station.getTimeZone())).minusDays(1).toString()
                                        .replaceAll("-", "");
        try {
            CurrentApiObject currentData = restTemplate.getForObject(
                            "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?station="
                                            + station.getCurrentSourceId()
                                            + "&begin_date="
                                            + yesterdayString
                                            + "&range=60&product=currents_predictions&units=english&time_zone=lst_ldt&format=json&interval=MAX_SLACK",
                            CurrentApiObject.class);
            for (CurrentPrediction prediction : currentData.getCurrent_predictions()
                            .getPredictions()) {
                prediction.setDateTime(prediction.getTime());
            }
            return currentData;
        } catch (Exception ex) {
            return null;
        }
    }

}
