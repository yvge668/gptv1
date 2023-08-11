package com.example.gptv1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {


    @Value("${baidu.key}")
    String apiKey;

    @Value("${baidu.region}")
    String region;

    @GetMapping("/weather")
    public ResponseEntity<String> getWeather() {

        //接口转发!!!
        String weatherApiUrl = "https://api.map.baidu.com/weather/v1/?district_id="+region+"&data_type=all&ak="+apiKey;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(weatherApiUrl, String.class);

        return response;
    }

}
