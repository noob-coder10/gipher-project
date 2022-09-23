package com.gipher.fetchapi.service;

import com.gipher.fetchapi.domain.Data;
import com.gipher.fetchapi.domain.JsonResponse;

public interface GifService {
    JsonResponse getTrendingGifs();
    JsonResponse searchGifsById(String gifName);
}
