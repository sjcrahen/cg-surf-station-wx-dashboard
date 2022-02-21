package com.shawncrahen.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.shawncrahen.application.contact.Contact;
import com.shawncrahen.application.data.ActiveStation;
import com.shawncrahen.application.data.CalculatedNextTide;
import com.shawncrahen.application.data.CalculatedPresentCurrent;
import com.shawncrahen.application.data.SeasObservation;
import com.shawncrahen.application.data.WeatherDto;
import com.shawncrahen.application.data.WindObservation;
import com.shawncrahen.application.entity.Station;
import com.shawncrahen.application.mail.EmailService;
import com.shawncrahen.application.service.CalculatedPresentCurrentService;
import com.shawncrahen.application.service.NextTideService;
import com.shawncrahen.application.service.SeasObservationService;
import com.shawncrahen.application.service.StationService;
import com.shawncrahen.application.service.WeatherService;
import com.shawncrahen.application.service.WindObservationService;
import com.shawncrahen.application.task.ApiUpdater;

@Controller
public class DashboardController {

  ApiUpdater apiUpdater;
  SeasObservationService seasObservationService;
  WindObservationService windObservationService;
  CalculatedPresentCurrentService calculatedPresentCurrentService;
  WeatherService weatherService;
  NextTideService nextTideService;
  ActiveStation activeStation;
  StationService stationService;
  EmailService emailService;

  private DashboardController(ApiUpdater apiUpdater, SeasObservationService seasObservationService,
          WindObservationService windObservationService,
          CalculatedPresentCurrentService calculatedPresentCurrentService,
          WeatherService weatherService, NextTideService nextTideService,
          ActiveStation activeStation, StationService stationService, EmailService emailService) {
    this.apiUpdater = apiUpdater;
    this.seasObservationService = seasObservationService;
    this.windObservationService = windObservationService;
    this.calculatedPresentCurrentService = calculatedPresentCurrentService;
    this.weatherService = weatherService;
    this.nextTideService = nextTideService;
    this.activeStation = activeStation;
    this.stationService = stationService;
    this.emailService = emailService;
  }

  @GetMapping("/test")
  public String test() {
    return "test";
  }

  @GetMapping("/stations")
  public String stations(Model model) {
    Iterable<Station> stations = stationService.getAllStations();
    model.addAttribute("stations", stations);
    return "stations";
  }

  @GetMapping("/stations/{stationId}")
  public String showDashboard(@PathVariable String stationId, Model model) {
    if (activeStation.getName() == null || !activeStation.getName().equals(stationId)) {
      activeStation.setName(stationId);
      apiUpdater.refreshAll();
    }
    Station station = stationService.getStation();
    model.addAttribute("station", station);

    SeasObservation seas = seasObservationService.getSeasObservation();
    model.addAttribute("seas", seas);

    WindObservation wind = windObservationService.getWindObservation();
    if (station.getWindSourceId() != null) {
      model.addAttribute("wind", wind);
    }

    if (station.getCurrentSourceId() != null) {
      CalculatedPresentCurrent current =
              calculatedPresentCurrentService.getCalculatedPresentCurrent();
      model.addAttribute("current", current);
    }

    WeatherDto weather = weatherService.getCurrentWeather();
    model.addAttribute("weather", weather);

    CalculatedNextTide nextTide = nextTideService.getNextTide();
    model.addAttribute("nextTide", nextTide);

    return "dashboard";
  }

  @GetMapping("/contact")
  public String showContact(Model model) {
    Contact contact = new Contact();
    model.addAttribute("contact", contact);
    return "contact";
  }

  @PostMapping("/contact")
  public String handleFormSubmission(Contact contact) throws Exception {
    emailService.sendEmail(contact);
    return "redirect:/contact/success";
  }

  @GetMapping("/contact/success")
  public String getSuccess() {
    return "success";
  }

}
