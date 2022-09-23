package com.gipher.fetchapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FixedHeight {
   @JsonProperty("height")
   private String height;
   @JsonProperty("width")
   private String width;
   @JsonProperty("size")
   private String size;
   @JsonProperty("url")
   private String url;
   @JsonProperty("mp4_size")
   private String mp4Size;
   @JsonProperty("mp4")
   private String mp4;
   @JsonProperty("webp_size")
   private String webpSize;
   @JsonProperty("webp")
   private String webp;

}
