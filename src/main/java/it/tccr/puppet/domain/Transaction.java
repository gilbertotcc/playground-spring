package it.tccr.puppet.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
public class Transaction {
  String transactionId;
  String accountId;
  String description;
  LocalDate bookedDate;
  MonetaryAmount amount;
}
