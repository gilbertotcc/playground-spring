package it.tccr.puppet.api;

import it.tccr.puppet.api.model.Connection;
import it.tccr.puppet.application.AccountConnectionService;
import it.tccr.puppet.domain.AccountConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class AccountConnectionsController implements AccountConnectionsApi {

  private final NativeWebRequest request;

  private final AccountConnectionService accountConnectionService;

  @Override
  public ResponseEntity<Connection> initializeConnection() {
    var accountConnection = accountConnectionService.initializeConnection();
    return ResponseEntity
      .status(CREATED)
      .body(toConnection(accountConnection));
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.of(request); // Capture the request to return an example of response
  }

  private Connection toConnection(AccountConnection accountConnection) {
    Connection connection = new Connection();
    connection.setAccountConnectionId(accountConnection.getAccountConnectionId());
    connection.setConnectionLink(accountConnection.getConnectLink());
    return connection;
  }
}
