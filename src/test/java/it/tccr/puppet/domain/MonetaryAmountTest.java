package it.tccr.puppet.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MonetaryAmountTest {

  @Test
  void monetaryAmountOfShouldSucceed() {
    var monetaryValue = "1.00";
    var currencyCode = "EUR";

    var monetaryAmount = MonetaryAmount.of(monetaryValue, currencyCode);

    assertThat(monetaryAmount.getValue()).isEqualByComparingTo(monetaryValue);
    assertThat(monetaryAmount.getCurrency().getCode()).isEqualTo(currencyCode);
  }

  @Test
  void monetaryAmountOfShouldFail() {
    assertThatThrownBy(() -> MonetaryAmount.of("invalid amount", "XXX"))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageStartingWith("Invalid monetary amount. Errors: ");
  }
}
