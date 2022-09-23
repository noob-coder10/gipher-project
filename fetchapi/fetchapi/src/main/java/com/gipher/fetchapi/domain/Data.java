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
public class Data {
       @JsonProperty("type")
       private String type;
       @JsonProperty("id")
       private String id;
       @JsonProperty("url")
       private String url;
       @JsonProperty("slug")
       private String slug;
       @JsonProperty("bitly_gif_url")
       private String bitlyGifUrl;
       @JsonProperty("bitly_url")
       private String bitlyUrl;
       @JsonProperty("embed_url")
       private String embedUrl;
       @JsonProperty("username")
       private String username;
       @JsonProperty("source")
       private String source;
       @JsonProperty("title")
       private String title;
       @JsonProperty("rating")
       private String rating;
       @JsonProperty("content_url")
       private String contentUrl;
       @JsonProperty("source_tld")
       private String sourceTld;
       @JsonProperty("source_post_url")
       private String sourcePostUrl;
       @JsonProperty("is_sticker")
       private int isSticker;
       @JsonProperty("import_datetime")
       private String importDatetime;
       @JsonProperty("trending_datetime")
       private String trendingDatetime;
       @JsonProperty("images")
       private Images images;
       @JsonProperty("user")
       private User user;
       @JsonProperty("analytics_response_payload")
       private String analyticsResponsePayload;
       @JsonProperty("analytics")
       private Analytics analytics;
}
