package it.tccr.puppet.api;

import it.tccr.puppet.api.model.Connection;
import it.tccr.puppet.api.model.CreateNewConnectionRequest;
import it.tccr.puppet.application.AccountConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AccountConnectionsController implements AccountConnectionsApi {

  private final NativeWebRequest request;

  private final AccountConnectionService accountConnectionService;

  @Override
  public ResponseEntity<Connection> createNewConnection(CreateNewConnectionRequest createNewConnectionRequest) {
    return AccountConnectionsApi.super.createNewConnection(createNewConnectionRequest);
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.of(request); // Capture the request to return an example of response
  }
}
