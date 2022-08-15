package it.tccr.puppet.infrastructure;

import it.tccr.puppet.application.AccountConnectionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TinkAccountConnectionClient implements AccountConnectionClient {

  private final TinkConfig tinkConfig;

  private final WebClient webClient;

  @Override
  public String getConnectionLink() {
    return "https://link.tink.com/1.0/transactions/connect-accounts?"
      + "client_id=%s".formatted(tinkConfig.getClientId())
      + "&"
      + "redirect_uri=http://yourdomain.com/callback";
  }

  @Override
  public Mono<String> exchangeCodeForAccessToken(String code) {
    MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
    formData.add("code", code);
    formData.add("client_id", tinkConfig.getClientId());
    formData.add("client_secret", tinkConfig.getClientSecret());
    formData.add("grant_type", "authorization_code");

    return webClient.post()
      .uri("https://api.tink.com/api/v1/oauth/token")
      .contentType(MediaType.APPLICATION_FORM_URLENCODED)
      .body(BodyInserters.fromFormData(formData))
      .exchangeToMono(response -> response.bodyToMono(AuthenticateResponse.class))
      .map(authenticateResponse -> authenticateResponse.accessToken);
  }
}
