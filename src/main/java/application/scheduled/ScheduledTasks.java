package application.scheduled;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import application.core.current.CurrentApiObject;
import application.core.current.CurrentService;
import application.core.ndbc.NdbcService;
import application.core.ndbc.SeasObservation;
import application.core.ndbc.WindObservation;
import application.core.station.DataCache;
import application.core.station.StationDto;
import application.core.station.StationService;
import application.core.tide.TideService;
import application.core.tide.TideApiResponse;
import application.core.weather.WeatherApiObject;
import application.core.weather.WeatherService;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    NdbcService ndbcService;

    @Autowired
    CurrentService currentService;

    @Autowired
    WeatherService weatherService;

    @Autowired
    TideService tideService;

    @Autowired
    DataCache dataCache;

    @Autowired
    StationService stationService;

    private static Iterable<StationDto> stations;
    private static Map<String, Map<String, Object>> map;

    @Scheduled(fixedRate = 180_000)
    public void updateSeasAndWindData() {
        if (stations == null) {
            stations = stationService.getAllStations();
        }
        if (map == null) {
            map = dataCache.getMap();
            stations.forEach(station -> {
                map.putIfAbsent(station.getStationId(), new HashMap<>());
                map.get(station.getStationId()).putIfAbsent("seas", null);
                if (station.getWaveSourceId2() != null) {
                    map.get(station.getStationId()).putIfAbsent("seas2", null);
                }
                map.get(station.getStationId()).putIfAbsent("wind", null);
            });
        }

        stations.forEach(station -> {
            if (station.getWaveSourceId() == station.getWindSourceId()) {
                Object[] obs = ndbcService.getCombinedSeasAndWindObservations(station);
                if (obs[0] != null) {
                    map.get(station.getStationId()).put("seas", obs[0]);
                }
                if (obs[1] != null) {
                    map.get(station.getStationId()).put("wind", obs[1]);
                }
            } else {
                SeasObservation seas = ndbcService.getSeasObservation(station.getWaveSourceId(),
                                station.getTimeZone());
                if (seas != null) {
                    map.get(station.getStationId()).put("seas", seas);
                }

                WindObservation wind = ndbcService.getWindObservation(station);
                if (wind != null) {
                    map.get(station.getStationId()).put("wind", wind);
                }
            }
            SeasObservation seas2 = ndbcService.getSeasObservation(station.getWaveSourceId2(),
                            station.getTimeZone());
            if (seas2 != null) {
                map.get(station.getStationId()).put("seas2", seas2);
            }
        });
    }

    @Scheduled(fixedRate = 21_600_000)
    public void updateCurrentData() {
        if (stations == null) {
            stations = stationService.getAllStations();
        }
        if (map == null) {
            map = dataCache.getMap();
            stations.forEach(station -> {
                map.putIfAbsent(station.getStationId(), new HashMap<>());
                map.get(station.getStationId()).putIfAbsent("current", null);
            });
        }
        stations.forEach(station -> {
            CurrentApiObject currentData = currentService.getCurrentData(station);
            if (currentData != null) {
                map.get(station.getStationId()).put("currentData", currentData);
            }
        });
    }

    @Scheduled(fixedRate = 420_000)
    public void getWeather() {
        if (stations == null) {
            stations = stationService.getAllStations();
        }
        if (map == null) {
            map = dataCache.getMap();
            stations.forEach(station -> {
                map.putIfAbsent(station.getStationId(), new HashMap<>());
                map.get(station.getStationId()).putIfAbsent("weather", null);
            });
        }

        stations.forEach(station -> {
            WeatherApiObject weather =
                            weatherService.getCurrentWeather(station.getWeatherSourceId());
            if (weather != null) {
                map.get(station.getStationId()).put("weather", weather);
            }
        });
    }

    @Scheduled(fixedRate = 21_600_000)
    public void updateTideData() {
        if (stations == null) {
            stations = stationService.getAllStations();
        }
        if (map == null) {
            map = dataCache.getMap();
            stations.forEach(station -> {
                map.putIfAbsent(station.getStationId(), new HashMap<>());
                map.get(station.getStationId()).putIfAbsent("tideData", null);
            });
        }

        stations.forEach(station -> {
            TideApiResponse tideData = tideService.getTideData(station);
            if (tideData != null) {
                map.get(station.getStationId()).put("tideData", tideData);
            }
        });
    }
}
