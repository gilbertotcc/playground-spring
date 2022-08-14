package it.tccr.puppet.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Account {

  String accountId;
}
