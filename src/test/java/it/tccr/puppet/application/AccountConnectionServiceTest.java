package it.tccr.puppet.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountConnectionServiceTest {

  @Test
  void initializeConnectionShouldSucceed() {
    // given
    var accountConnectionClient = mock(AccountConnectionClient.class);
    when(accountConnectionClient.getConnectionLink()).thenReturn("http://www.example.com");
    var accountConnectionService = new AccountConnectionService(accountConnectionClient);

    // when
    var accountConnection = accountConnectionService.initializeConnection();

    // then
    assertThat(accountConnection.getConnectLink()).isEqualTo("http://www.example.com");
  }
}
