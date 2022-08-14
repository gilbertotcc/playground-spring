package it.tccr.puppet.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class AccountConnection {
  String accountConnectionId;
  String connectLink;
}
