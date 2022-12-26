package application.controllers;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import application.core.current.CurrentApiObject;
import application.core.current.CurrentService;
import application.core.station.DataCache;
import application.core.station.StationDto;
import application.core.station.StationService;
import application.core.tide.TideApiResponse;
import application.core.tide.TideService;
import application.core.weather.WeatherService;

@Controller
public class DashboardController {

    Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    CurrentService currentService;

    @Autowired
    WeatherService weatherService;

    @Autowired
    TideService tideService;

    @Autowired
    StationService stationService;

    @Autowired
    DataCache dataCache;

    private static Iterable<StationDto> stations;
    private static Map<String, Map<String, Object>> dataCacheMap;

    private DashboardController() {}

    @GetMapping("/")
    public String index() {
        return "redirect:/stations";
    }

    @GetMapping("/stations")
    public String stations(Model model) {
        if (stations == null) {
            stations = stationService.getAllStations();
        }
        model.addAttribute("stations", stations);
        return "stations";
    }

    @GetMapping("/stations/{stationId}")
    public String showDashboard(@PathVariable String stationId, Model model) {
        if (dataCacheMap == null) {
            dataCacheMap = dataCache.getMap();
        }
        if (stations == null) {
            stations = stationService.getAllStations();
        }
        StationDto station = stationService.getStation(stationId);

        model.addAttribute("stationsList", stations);
        model.addAttribute("station", station);
        model.addAttribute("currentTime", ZonedDateTime.now(ZoneId.of(station.getTimeZone())));
        model.addAttribute("seas", dataCacheMap.get(station.getStationId()).get("seas"));
        model.addAttribute("seas2", dataCacheMap.get(station.getStationId()).get("seas2"));
        model.addAttribute("wind", dataCacheMap.get(station.getStationId()).get("wind"));
        model.addAttribute("weather", dataCacheMap.get(station.getStationId()).get("weather"));
        model.addAttribute("current", currentService.getCalculatedPresentCurrent(station,
                        (CurrentApiObject) dataCacheMap.get(station.getStationId())
                                        .get("currentData")));
        model.addAttribute("nextTide", tideService.getCalculatedNextTide(station,
                        (TideApiResponse) dataCacheMap.get(station.getStationId())
                                        .get("tideData")));

        return "dashboard";
    }
}
