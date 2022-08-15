package it.tccr.puppet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Currency {
  EUR("EUR");

  final String code;

  public static Currency byCode(String code) {
    return Arrays.stream(values())
      .filter(currency -> currency.code.equals(code))
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException("Unknown %s currency code".formatted(code)));
  }
}
