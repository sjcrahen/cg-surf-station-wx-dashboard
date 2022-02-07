package com.shawncrahen.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.shawncrahen.application.api.WeatherApiResponse;
import com.shawncrahen.application.data.CalculatedPresentCurrent;
import com.shawncrahen.application.data.SeasObservation;
import com.shawncrahen.application.data.WindObservation;
import com.shawncrahen.application.service.CalculatedPresentCurrentService;
import com.shawncrahen.application.service.SeasObservationService;
import com.shawncrahen.application.service.WindObservationService;
import com.shawncrahen.application.task.ScheduledWeatherApiUpdater;

@Controller
public class DashboardController {

  @Autowired
  SeasObservationService seasObservationService;

  @Autowired
  WindObservationService windObservationService;

  @Autowired
  CalculatedPresentCurrentService calculatedPresentCurrentService;

  @Autowired
  ScheduledWeatherApiUpdater scheduledWeatherApiUpdater;

  @GetMapping("/units/{unit}")
  public String showDashboard(Model model) {
    SeasObservation seas = seasObservationService.getSeasObservation();
    model.addAttribute("seas", seas);

    WindObservation wind = windObservationService.getWindObservation();
    model.addAttribute("wind", wind);

    CalculatedPresentCurrent current =
            calculatedPresentCurrentService.getCalculatedPresentCurrent();
    model.addAttribute("current", current);

    WeatherApiResponse weather = scheduledWeatherApiUpdater.getWeatherApiResponse();
    model.addAttribute("weather", weather);

    return "dashboard";
  }


}
