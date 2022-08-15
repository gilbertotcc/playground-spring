package it.tccr.puppet.infrastructure;

import io.netty.handler.logging.LogLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Configuration
@EnableConfigurationProperties(value = {
  TinkConfig.class
})
@EnableAutoConfiguration
@RequiredArgsConstructor
public class TinkClientConfiguration {

  private final TinkConfig tinkConfig;

  @Bean
  public WebClient webClient() {
    HttpClient httpClient = HttpClient.create()
      .wiretap(this.getClass().getCanonicalName(), LogLevel.INFO, AdvancedByteBufFormat.TEXTUAL);
    ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

    return WebClient.builder()
      .clientConnector(connector)
      .build();
  }
}
