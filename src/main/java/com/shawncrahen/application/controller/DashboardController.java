package com.shawncrahen.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shawncrahen.application.api.WeatherApiResponse;
import com.shawncrahen.application.data.ActiveStation;
import com.shawncrahen.application.data.CalculatedNextTide;
import com.shawncrahen.application.data.CalculatedPresentCurrent;
import com.shawncrahen.application.data.SeasObservation;
import com.shawncrahen.application.data.WindObservation;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.service.CalculatedPresentCurrentService;
import com.shawncrahen.application.service.NextTideService;
import com.shawncrahen.application.service.SeasObservationService;
import com.shawncrahen.application.service.StationService;
import com.shawncrahen.application.service.WeatherService;
import com.shawncrahen.application.service.WindObservationService;
import com.shawncrahen.application.task.ApiUpdater;

@Controller
@RequestMapping("/stations")
public class DashboardController {

  ApiUpdater apiUpdater;
  SeasObservationService seasObservationService;
  WindObservationService windObservationService;
  CalculatedPresentCurrentService calculatedPresentCurrentService;
  WeatherService weatherService;
  NextTideService nextTideService;
  ActiveStation activeStation;
  StationService stationService;

  private DashboardController(ApiUpdater apiUpdater, SeasObservationService seasObservationService,
          WindObservationService windObservationService,
          CalculatedPresentCurrentService calculatedPresentCurrentService,
          WeatherService weatherService, NextTideService nextTideService,
          ActiveStation activeStation, StationService stationService) {
    this.apiUpdater = apiUpdater;
    this.seasObservationService = seasObservationService;
    this.windObservationService = windObservationService;
    this.calculatedPresentCurrentService = calculatedPresentCurrentService;
    this.weatherService = weatherService;
    this.nextTideService = nextTideService;
    this.activeStation = activeStation;
    this.stationService = stationService;
  }

  @GetMapping("/{stationId}")
  public String showDashboard(@PathVariable String stationId, Model model) {
    if (activeStation.getName() == null || !activeStation.getName().equals(stationId)) {
      activeStation.setName(stationId);
      apiUpdater.refreshAll();
    }

    Station station = stationService.getStation();
    model.addAttribute("stationName", station.getStationName());

    SeasObservation seas = seasObservationService.getSeasObservation();
    model.addAttribute("seas", seas);

    WindObservation wind = windObservationService.getWindObservation();
    model.addAttribute("wind", wind);

    CalculatedPresentCurrent current =
            calculatedPresentCurrentService.getCalculatedPresentCurrent();
    model.addAttribute("current", current);

    WeatherApiResponse weather = weatherService.getCurrentWeather();
    model.addAttribute("weather", weather);

    CalculatedNextTide nextTide = nextTideService.getNextTide();
    model.addAttribute("nextTide", nextTide);

    return "dashboard";
  }


}
