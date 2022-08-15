package it.tccr.puppet.api;

import it.tccr.puppet.application.AccountConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

@RestController
@RequiredArgsConstructor
public class AccountConnectionCallbackController implements AccountConnectionCallbackApi {

  private final AccountConnectionService accountConnectionService;

  private final NativeWebRequest request;

  @Override
  public ResponseEntity<Void> notifyAggregationCompleted(String code, String credentialsId) {
    var accountConnection = accountConnectionService.connectAccounts(code);
    return ResponseEntity
      .status(MOVED_PERMANENTLY)
      .header(HttpHeaders.LOCATION, "https://console.tink.com/callback")
      .build();
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.of(request); // Capture the request to return an example of response
  }
}
