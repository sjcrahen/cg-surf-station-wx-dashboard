package application.core.tide;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import application.core.station.StationDto;

@Service
public class TideService {

    private RestTemplate restTemplate;

    public TideService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CalculatedNextTide getCalculatedNextTide(StationDto station, TideApiResponse tideData) {
        TidePredictions[] predictions = tideData.getPredictions();

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(station.getTimeZone()));
        int i = 0;
        while (now.compareTo(
                        ZonedDateTime.of(predictions[i].getDateTime(),
                                        ZoneId.of(station.getTimeZone()))) > 0) {
            i++;
        }
        return new CalculatedNextTide(
                        predictions[i].getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                        predictions[i].getType(), predictions[i].getHeight());
    }

    public TideApiResponse getTideData(StationDto station) {
        String todayString =
                        LocalDate.now(ZoneId.of(station.getTimeZone())).toString().replaceAll("-",
                                        "");
        try {
            TideApiResponse tideData = restTemplate.getForObject(
                            "https://api.tidesandcurrents.noaa.gov/api/prod/datagetter?begin_date="
                                            + todayString
                                            + "&range=48&station="
                                            + station.getTideSourceId()
                                            + "&product=predictions&datum=mllw&interval=hilo&units=english&time_zone=lst_ldt&format=json",
                            TideApiResponse.class);
            return tideData;
        } catch (Exception ex) {
            return null;
        }
    }


}
