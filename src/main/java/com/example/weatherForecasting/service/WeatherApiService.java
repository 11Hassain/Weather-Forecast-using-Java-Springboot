package com.example.weatherForecasting.service;

import com.example.weatherForecasting.exception.WeatherDataNotFoundException;
import com.example.weatherForecasting.pojo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class WeatherApiService {

    private final RestTemplate restTemplate;
    private final Logger log = LoggerFactory.getLogger(WeatherApiService.class);

    @Value("${openweathermap.api.key}")
    private String apiKey;

    public Object getWeatherDataByCity(String city){
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        return restTemplate.getForObject(url, Object.class);
    }

    public WeatherResponse getWeatherByCity(String city){
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        String jsonResponse = restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonResponse, WeatherResponse.class);
        } catch (IOException e){
            log.warn("Error fetching weather data for city: "+city, e);
            throw new WeatherDataNotFoundException("Failed to fetch weather data for city: "+city);
        }
    }
}
