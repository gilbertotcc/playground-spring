package it.tccr.puppet.domain;

import org.junit.jupiter.api.Test;

import static it.tccr.puppet.domain.Currency.EUR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CurrencyTest {

  @Test
  void currencyByCodeShouldSucceedWithValidCurrencyCode() {
    var currencyCode = "EUR";

    var currency = Currency.byCode(currencyCode);

    assertThat(currency).isEqualTo(EUR);
  }

  @Test
  void currencyByCodeShouldFailWithInvalidCurrencyCode() {
    var currencyCode = "XXX";

    assertThatThrownBy(() -> Currency.byCode(currencyCode))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Unknown XXX currency code");
  }
}
