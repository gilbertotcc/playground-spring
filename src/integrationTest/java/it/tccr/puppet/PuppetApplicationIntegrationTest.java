package it.tccr.puppet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("integrationTest")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PuppetApplicationIntegrationTest {

  @Autowired
  private ApplicationContext appContext;

  @Test
  void contextLoads() {
    assertThat(appContext).isNotNull();
  }

}
