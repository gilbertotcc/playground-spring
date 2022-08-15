package it.tccr.puppet.application;

import io.vavr.control.Option;
import it.tccr.puppet.domain.AccountConnection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountConnectionService {

  private final AccountConnectionClient accountConnectionClient;

  public AccountConnection initializeConnection() {
    var connectionLink = accountConnectionClient.getConnectionLink();
    return AccountConnection.builder()
      .accountConnectionId(UUID.randomUUID().toString())
      .connectLink(connectionLink)
      .accessToken(Option.none())
      .build();
  }

  public AccountConnection connectAccounts(String code) {
    var accessToken = accountConnectionClient.exchangeCodeForAccessToken(code).block();
    return AccountConnection.builder()
      .accessToken(Option.some(accessToken))
      .build();
  }

}
