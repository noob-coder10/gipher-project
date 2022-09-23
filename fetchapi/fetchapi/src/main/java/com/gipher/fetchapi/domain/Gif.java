package com.gipher.fetchapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class Gif {
  private String id;
  private String username;
  private String title;
  private String url;
  private String original_url;
  private int is_sticker;

  public Gif() {
    super();
  }

  public Gif(String id, String username, String title, String url, String original_url, int is_sticker) {
    super();
    this.id = id;
    this.username = username;
    this.title = title;
    this.url = url;
    this.original_url = original_url;
    this.is_sticker = is_sticker;
  }
}
