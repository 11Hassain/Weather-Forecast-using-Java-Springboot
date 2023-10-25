package com.example.weatherForecasting.controller;

import com.example.weatherForecasting.pojo.WeatherResponse;
import com.example.weatherForecasting.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherApiService service;

    @GetMapping
    public WeatherResponse getWeatherDataByCity(@RequestParam String city){
        return service.getWeatherByCity(city);
    }

    @GetMapping("/obj")
    public Object getWeatherByCity(@RequestParam String city){
        return service.getWeatherDataByCity(city);
    }

}
