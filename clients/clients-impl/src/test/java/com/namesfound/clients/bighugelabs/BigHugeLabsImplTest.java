package com.namesfound.clients.bighugelabs;

import static org.fest.assertions.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author marcel-serra.ribeiro on 24/07/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class BigHugeLabsImplTest {
  private static final String VALID_WORD = "love";
  private static final String URL = "http://someurl.com";
  private static final String PATH1 = "path1";
  private static final String PATH2 = "path2";
  private static final String[] PATHS = new String[] { PATH1, PATH2 };
  private static final String KEY_VALUE = "KEY123";
  private static final String RESPONSE_FORMAT = "json";

  @InjectMocks
  private BigHugeLabsImpl bigHugeLabsImpl = new BigHugeLabsImpl();

  @Before
  public void setup() {
    ReflectionTestUtils.setField(bigHugeLabsImpl, "url", URL);
    ReflectionTestUtils.setField(bigHugeLabsImpl, "paths", PATHS);
    ReflectionTestUtils.setField(bigHugeLabsImpl, "keyValue", KEY_VALUE);
    ReflectionTestUtils.setField(bigHugeLabsImpl, "responseFormat", RESPONSE_FORMAT);
  }

  @Test
  public void testGetWebTarget() throws URISyntaxException {
    // Given
    String expectedUrl = URL + "/" + PATH1 + "/" + PATH2 + "/" + KEY_VALUE + "/" + VALID_WORD + "/" + RESPONSE_FORMAT;
    Client client = ClientBuilder.newClient();
    URI expectedTargetUri = new URI(expectedUrl);

    // When
    WebTarget webTarget = bigHugeLabsImpl.getWebTarget(client, VALID_WORD);

    // Then
    assertThat(webTarget).isNotNull();
    assertThat(webTarget.getUri()).isEqualTo(expectedTargetUri);

  }


}
