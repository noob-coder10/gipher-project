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
public class Meta {
    @JsonProperty("status")
   private int status;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("response_id")
    private String responseId;

}
