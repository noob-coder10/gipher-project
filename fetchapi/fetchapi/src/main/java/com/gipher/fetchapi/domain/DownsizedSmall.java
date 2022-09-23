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
public class DownsizedSmall {
    @JsonProperty("height")
    private String height;
    @JsonProperty("width")
    private String width;
    @JsonProperty("mp4_size")
    private String mp4Size;
    @JsonProperty("mp4")
    private String mp4;
}
