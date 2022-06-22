package it.tccr.puppet.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class HealthcheckController implements HealthcheckApi {

  private final NativeWebRequest request;

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.of(request); // Capture the request to return an example of response
  }
}
