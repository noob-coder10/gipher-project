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
public class Analytics {
    @JsonProperty("onload")
    private Onload onload;
    @JsonProperty("onclick")
    private Onload onclick;
    @JsonProperty("onsent")
    private Onload onsent;

}
