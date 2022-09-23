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
public class JsonResponse {
@JsonProperty("data")
    private Data[] data;
@JsonProperty("pagination")
     private Pagination pagination;
@JsonProperty("meta")
    private Meta meta;
}
