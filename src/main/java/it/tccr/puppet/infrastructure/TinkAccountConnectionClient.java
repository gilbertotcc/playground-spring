package it.tccr.puppet.infrastructure;

import it.tccr.puppet.application.AccountConnectionClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TinkAccountConnectionClient implements AccountConnectionClient {

  private final String baseUrl;
  private final String clientId;
  private final String clientSecret;
  private final RestTemplate restTemplate;

  public TinkAccountConnectionClient(
    @Value("${account-aggregator.tink.base-url}") String baseUrl,
    @Value("${account-aggregator.tink.client-id}") String clientId,
    @Value("${account-aggregator.tink.client-secret}") String clientSecret,
    RestTemplate restTemplate
  ) {
    this.baseUrl = baseUrl;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.restTemplate = restTemplate;
  }

  @Override
  public String getConnectionLink() {
    return "https://link.tink.com/1.0/transactions/connect-accounts?"
      + "client_id=%s".formatted(clientId)
      + "&"
      + "redirect_uri=http://yourdomain.com/callback";
  }
}
