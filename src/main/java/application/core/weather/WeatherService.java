package application.core.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

  private RestTemplate restTemplate;

  public WeatherService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public WeatherApiObject getCurrentWeather(String weatherSourceId) {
    WeatherApiObject weather = restTemplate.getForObject(
            "http://api.weatherapi.com/v1/forecast.json?key=3436a533716643b989d191452220402&q="
                    + weatherSourceId
                    + "&aqi=no",
            WeatherApiObject.class);
    weather.setChanceOfPrecip();
    return weather;
  }

}
