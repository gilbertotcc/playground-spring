package it.tccr.puppet.infrastructure;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

import java.io.IOException;

@ActiveProfiles("integrationTest")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TinkClientIntegrationTest {

  private static MockWebServer mockedTinkServer;

  @Autowired
  private TinkClient tinkClient;

  @BeforeAll
  static void setUp() throws IOException {
    mockedTinkServer = new MockWebServer();
    mockedTinkServer.start(9000);
  }

  @AfterAll
  static void tearDown() throws IOException {
    mockedTinkServer.shutdown();
  }

  @Test
  void exchangeCodeShouldReturnToken() throws InterruptedException {
    // given
    setupGetAccessTokenResponseSuccess("accessToken");
    var tinkCode = "tinkCode";

    // when
    var accessToken = tinkClient.exchangeCode(tinkCode);

    // then
    StepVerifier.create(accessToken)
      .expectNext("accessToken")
      .expectComplete()
      .verify();
  }

  private void setupGetAccessTokenResponseSuccess(String accessToken) {
    mockedTinkServer.enqueue(new MockResponse()
      .setResponseCode(200)
      .addHeader("Content-Type", "application/json")
      .setBody("""
        {
          "token_type": "bearer",
          "expires_in": 7200,
          "access_token": "%s",
          "refresh_token": "6e80e020a24e4c1cb8d4aa8b3b7f517d",
          "scope": "accounts:read,balances:read,transactions:read",
          "id_hint": ""
        }
        """.formatted(accessToken)
      )
    );
  }
}
