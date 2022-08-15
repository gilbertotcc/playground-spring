package it.tccr.puppet;

import it.tccr.puppet.infrastructure.TinkConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = { PuppetApplication.class })
@ActiveProfiles("test")
class PuppetApplicationTests {

  @Autowired
  private TinkConfig tinkConfig;

  @Test
  void contextLoads() {
  }

}
