package com.gipher.fetchapi.service;

import com.gipher.fetchapi.domain.Data;
import com.gipher.fetchapi.domain.JsonResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GifServiceImpl implements GifService{
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    public GifServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public JsonResponse getTrendingGifs() {
        return restTemplate.getForObject("https://api.giphy.com/v1/gifs/trending?api_key={apiKey}",JsonResponse.class,apiKey);
    }

    @Override
    public JsonResponse searchGifsById(String gifName) {
        return restTemplate.getForObject("https://api.giphy.com/v1/gifs/search?q={gifName}&api_key={apiKey}",JsonResponse.class,gifName,apiKey);
    }
}
