package com.gipher.fetchapi.controller;


import com.gipher.fetchapi.domain.Data;
import com.gipher.fetchapi.domain.Gif;
import com.gipher.fetchapi.domain.JsonResponse;
import com.gipher.fetchapi.service.GifService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GifController {
    private GifService gifService;
    public GifController(GifService gifService)
    {
       this.gifService=gifService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Gif>>getTrendingGifs()
    {
        JsonResponse data=gifService.getTrendingGifs();
      List<Gif> gifs = new ArrayList<Gif>();
      for(int i=0; i<data.getData().length; i++)
      {
        Gif gif = new Gif();
        gif.setId(data.getData()[i].getId());
        gif.setUsername(data.getData()[i].getUsername());
        gif.setTitle(data.getData()[i].getTitle());
        gif.setUrl(data.getData()[i].getImages().getDownsized().getUrl());
        gif.setOriginal_url(data.getData()[i].getImages().getOriginal().getUrl());
        gif.setIs_sticker(data.getData()[i].getIsSticker());

        gifs.add(gif);
      }
      return ResponseEntity.ok(gifs);
    }
    @GetMapping("/{gifName}")
    public ResponseEntity<List<Gif>> searchGifsById(@PathVariable String gifName) {
        JsonResponse data = gifService.searchGifsById(gifName);
        List<Gif> gifs = new ArrayList<Gif>();
        for(int i=0; i<data.getData().length; i++)
        {
          Gif gif = new Gif();
          gif.setId(data.getData()[i].getId());
          gif.setUsername(data.getData()[i].getUsername());
          gif.setTitle(data.getData()[i].getTitle());
          gif.setUrl(data.getData()[i].getImages().getDownsized().getUrl());
          gif.setOriginal_url(data.getData()[i].getImages().getOriginal().getUrl());
          gif.setIs_sticker(data.getData()[i].getIsSticker());

          gifs.add(gif);
        }
        return ResponseEntity.ok(gifs);
    }


}
