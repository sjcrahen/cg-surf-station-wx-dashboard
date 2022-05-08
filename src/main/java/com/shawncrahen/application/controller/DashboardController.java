package com.shawncrahen.application.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.shawncrahen.application.contact.Contact;
import com.shawncrahen.application.data.CalculatedNextTide;
import com.shawncrahen.application.data.CalculatedPresentCurrent;
import com.shawncrahen.application.data.SeasObservation;
import com.shawncrahen.application.data.StationDto;
import com.shawncrahen.application.data.WindObservation;
import com.shawncrahen.application.mail.EmailService;
import com.shawncrahen.application.rest.weather.WeatherApiObject;
import com.shawncrahen.application.service.CalculatedPresentCurrentService;
import com.shawncrahen.application.service.NextTideService;
import com.shawncrahen.application.service.SeasObservationService;
import com.shawncrahen.application.service.StationService;
import com.shawncrahen.application.service.WeatherService;
import com.shawncrahen.application.service.WindObservationService;

@Controller
public class DashboardController {

  SeasObservationService seasObservationService;
  WindObservationService windObservationService;
  CalculatedPresentCurrentService calculatedPresentCurrentService;
  WeatherService weatherService;
  NextTideService nextTideService;
  StationService stationService;
  EmailService emailService;

  private DashboardController(SeasObservationService seasObservationService,
          WindObservationService windObservationService,
          CalculatedPresentCurrentService calculatedPresentCurrentService,
          WeatherService weatherService, NextTideService nextTideService,
          StationService stationService, EmailService emailService) {
    this.seasObservationService = seasObservationService;
    this.windObservationService = windObservationService;
    this.calculatedPresentCurrentService = calculatedPresentCurrentService;
    this.weatherService = weatherService;
    this.nextTideService = nextTideService;
    this.stationService = stationService;
    this.emailService = emailService;
  }

  @GetMapping("/test")
  public String test() {
    return "test";
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

    SeasObservation seas = seasObservationService.getSeasObservation(stationDto.getWaveSourceId(),
            stationDto.getTimeZone());
    model.addAttribute("seas", seas);

    SeasObservation seas2 = seasObservationService.getSeasObservation(stationDto.getWaveSourceId2(),
            stationDto.getTimeZone());
    model.addAttribute("seas2", seas2);

    WindObservation wind = windObservationService.getWindObservation(stationDto.getWindSourceId(),
            stationDto.getTimeZone());
    model.addAttribute("wind", wind);

    CalculatedPresentCurrent current =
            calculatedPresentCurrentService.getCalculatedPresentCurrent(stationDto);
    model.addAttribute("current", current);

    WeatherApiObject weather = weatherService.getCurrentWeather(stationDto.getWeatherSourceId());
    model.addAttribute("weather", weather);

    CalculatedNextTide nextTide = nextTideService.getNextTide(stationDto);
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
