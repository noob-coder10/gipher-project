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
public class Images {
    @JsonProperty("original")
    private Original original;
    @JsonProperty("downsized")
    private Downsized downsized;
    @JsonProperty("downsized_large")
    private Downsized downsizedLarge;
    @JsonProperty("downsized_medium")
    private Downsized downsizedMedium;
    @JsonProperty("downsized_small")
    private DownsizedSmall downsizedSmall;
    @JsonProperty("downsized_still")
    private Downsized downsizedStill;
    @JsonProperty("fixed_height")
    private FixedHeight fixedHeight;
    @JsonProperty("fixed_height_downsampled")
    private FixedHeightDownsampled fixedHeightDownsampled;
    @JsonProperty("fixed_height_small")
    private FixedHeight fixedHeightSmall;
    @JsonProperty("fixed_height_small_still")
    private Downsized fixedHeightSmallStill;
    @JsonProperty("fixed_height_still")
    private Downsized fixedHeightStill;
    @JsonProperty("fixed_width")
    private FixedHeight fixedWidth;
    @JsonProperty("fixed_width_downsampled")
    private FixedHeightDownsampled fixedWidthDownsampled;
    @JsonProperty("fixed_width_small")
    private FixedHeight fixedWidthSmall;
    @JsonProperty("fixed_width_small_still")
    private Downsized fixedWidthSmallStill;
    @JsonProperty("fixed_width_still")
    private Downsized fixedWidthStill;
    @JsonProperty("looping")
    private Looping looping;
    @JsonProperty("original_still")
    private Downsized originalStill;
    @JsonProperty("original_mp4")
    private DownsizedSmall originalMp4;
    @JsonProperty("preview")
    private DownsizedSmall preview;
    @JsonProperty("preview_gif")
    private Downsized previewGif;
    @JsonProperty("preview_webp")
    private Downsized previewWebp;
    @JsonProperty("hd")
    private DownsizedSmall hd;
    @JsonProperty("d480w_still")
    private Downsized d480wStill;

}
