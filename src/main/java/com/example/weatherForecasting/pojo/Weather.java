package com.example.weatherForecasting.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
