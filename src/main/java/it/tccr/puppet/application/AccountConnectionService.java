package it.tccr.puppet.application;

import it.tccr.puppet.domain.AccountConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountConnectionService {

  private final AccountConnectionClient accountConnectionClient;

  public AccountConnection initializeConnection() {
    var connectionLink = accountConnectionClient.getConnectionLink();
    return AccountConnection.of(UUID.randomUUID().toString(), connectionLink);
  }

}
