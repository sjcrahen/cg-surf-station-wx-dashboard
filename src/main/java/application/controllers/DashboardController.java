package application.controllers;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import application.core.current.CalculatedPresentCurrent;
import application.core.current.CalculatedPresentCurrentService;
import application.core.seas.SeasObservation;
import application.core.seas.SeasObservationService;
import application.core.station.StationDto;
import application.core.station.StationService;
import application.core.tide.CalculatedNextTide;
import application.core.tide.NextTideService;
import application.core.weather.WeatherApiObject;
import application.core.weather.WeatherService;
import application.core.wind.WindObservation;
import application.core.wind.WindObservationService;

@Controller
public class DashboardController {

    @Autowired
    SeasObservationService seasObservationService;

    @Autowired
    WindObservationService windObservationService;

    @Autowired
    CalculatedPresentCurrentService calculatedPresentCurrentService;

    @Autowired
    WeatherService weatherService;

    @Autowired
    NextTideService nextTideService;

    @Autowired
    StationService stationService;

    private DashboardController() {}

    @GetMapping("/")
    public String index() {
        return "redirect:/stations";
    }

    @GetMapping("/stations")
    public String stations(Model model) {
        Iterable<StationDto> stations = stationService.getAllStations();
        model.addAttribute("stations", stations);
        return "stations";
    }

    @GetMapping("/stations/{stationId}")
    public String showDashboard(@PathVariable String stationId, Model model) {

        Iterable<StationDto> stationsList = stationService.getAllStations();
        model.addAttribute("stationsList", stationsList);

        StationDto stationDto = stationService.getStation(stationId);
        model.addAttribute("station", stationDto);

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(stationDto.getTimeZone()));
        model.addAttribute("currentTime", now);

        SeasObservation seas =
                        seasObservationService.getSeasObservation(stationDto.getWaveSourceId(),
                                        stationDto.getTimeZone());
        model.addAttribute("seas", seas);

        SeasObservation seas2 =
                        seasObservationService.getSeasObservation(stationDto.getWaveSourceId2(),
                                        stationDto.getTimeZone());
        model.addAttribute("seas2", seas2);

        WindObservation wind =
                        windObservationService.getWindObservation(stationDto.getWindSourceId(),
                                        stationDto.getTimeZone());
        model.addAttribute("wind", wind);

        CalculatedPresentCurrent current =
                        calculatedPresentCurrentService.getCalculatedPresentCurrent(stationDto);
        model.addAttribute("current", current);

        WeatherApiObject weather =
                        weatherService.getCurrentWeather(stationDto.getWeatherSourceId());
        model.addAttribute("weather", weather);

        CalculatedNextTide nextTide = nextTideService.getNextTide(stationDto);
        model.addAttribute("nextTide", nextTide);

        return "dashboard";
    }
}
