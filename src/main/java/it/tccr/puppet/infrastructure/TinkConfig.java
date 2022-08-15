package it.tccr.puppet.infrastructure;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "account-aggregator.tink")
@ConstructorBinding
@Value
public class TinkConfig {
  String baseUrl;
  String clientId;
  String clientSecret;
}
