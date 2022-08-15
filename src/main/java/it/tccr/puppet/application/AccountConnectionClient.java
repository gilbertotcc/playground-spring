package it.tccr.puppet.application;

import reactor.core.publisher.Mono;

public interface AccountConnectionClient {

  Mono<String> exchangeCode(String code);
}
