package com.namesfound.clients.bighugelabs;

import static org.fest.assertions.Assertions.assertThat;

import com.namesfound.clients.bighugelabs.config.BigHugeLabsConfig;
import com.namesfound.clients.helpers.config.ClientsHelpersConfig;
import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author marcel-serra.ribeiro on 24/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BigHugeLabsConfig.class, ClientsHelpersConfig.class })
public class BigHugeLabsImplTest {
  private static final String VALID_WORD = "love";

  @Autowired
  private BigHugeLabsImpl bigHugeLabsImpl;

  @Test
  public void testGetTheSaurus() throws Exception {
    // When
    Object responseValid = bigHugeLabsImpl.getTheSaurus(VALID_WORD);

    // Then
    assertThat(responseValid).isNotNull();
  }

  @Test
  public void testGetWebTarget() throws URISyntaxException {
    // Given
    String expectedUrl = "http://words.bighugelabs.com/api/2/d4c201de8f6a7b05e5da536876432cdf/"+VALID_WORD+"/json";
    Client client = ClientBuilder.newClient();
    URI expectedTargetUri = new URI(expectedUrl);

    // When
    WebTarget webTarget = bigHugeLabsImpl.getWebTarget(client, VALID_WORD);

    // Then
    assertThat(webTarget).isNotNull();
    assertThat(webTarget.getUri()).isEqualTo(expectedTargetUri);

  }
}