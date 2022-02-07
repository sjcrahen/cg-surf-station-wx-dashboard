package com.shawncrahen.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.shawncrahen.application.data.WaveData;
import com.shawncrahen.application.data.WindData;
import com.shawncrahen.application.task.ScheduledTasks;

@Controller
public class DashboardController {

  @Autowired
  WaveData waveData;

  @Autowired
  WindData windData;

  @Autowired
  ScheduledTasks scheduledTasks;

  @GetMapping("/units/{unit}")
  public String showDashboard(Model model) {
    model.addAttribute("waveData", waveData);
    model.addAttribute("windData", windData);
    model.addAttribute("current", scheduledTasks.getCurrentApiResponse().getCurrent_predictions()
            .calculatePresentCurrent());
    model.addAttribute("weather", scheduledTasks.getWeatherApiResponse());
    return "dashboard";
  }


}
