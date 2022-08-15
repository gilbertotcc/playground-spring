package it.tccr.puppet.application;

import reactor.core.publisher.Mono;

public interface AccountConnectionClient {

  String getConnectionLink();

  Mono<String> exchangeCodeForAccessToken(String code);
}
