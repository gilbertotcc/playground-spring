package it.tccr.puppet.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AccountConnectionsController implements AccountConnectionsApi {

  private final NativeWebRequest request;

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.of(request); // Capture the request to return an example of response
  }
}
