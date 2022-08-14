package it.tccr.puppet.domain;

import io.vavr.control.Try;
import io.vavr.control.Validation;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Getter
public class MonetaryAmount {

  BigDecimal value;
  Currency currency;

  public static MonetaryAmount of(String value, String currencyCode) {
    var validatedValue = Try.of(() -> new BigDecimal(value)).toValidation(Throwable::getMessage);
    var validatedCurrency = Try.of(() -> Currency.byCode(currencyCode)).toValidation(Throwable::getMessage);
    return Validation.combine(validatedValue, validatedCurrency)
      .ap(MonetaryAmount::new)
      .mapError(validationErrors -> String.join(",", validationErrors.asJava()))
      .toEither()
      .getOrElseThrow(error -> new IllegalArgumentException("Invalid monetary amount. Errors: %s".formatted(error)));
  }
}
