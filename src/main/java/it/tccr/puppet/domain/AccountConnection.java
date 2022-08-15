package it.tccr.puppet.domain;

import io.vavr.control.Option;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class AccountConnection {
  String accountConnectionId;
  String connectLink;
  Option<String> accessToken;
}
