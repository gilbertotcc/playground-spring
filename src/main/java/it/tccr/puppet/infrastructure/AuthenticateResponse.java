package it.tccr.puppet.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticateResponse {
  @JsonProperty("access_token")
  String accessToken;
}
