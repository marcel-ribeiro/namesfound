package com.namesfound.clients.merriamwebster;

import static org.fest.assertions.Assertions.assertThat;

import com.namesfound.clients.merriamwebster.config.MerriamWebsterConfig;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author marcel-serra.ribeiro on 20/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MerriamWebsterConfig.class })
public class MerriamWebsterThesaurusImplTest extends TestCase {

  private static final String VALID_WORD = "valid";
  @Autowired
  private MerriamWebsterThesaurusImpl merriamWebsterThesaurusImpl;

  @Test
  public void testGetWebTarget() throws Exception {
    //Given
    Client client = ClientBuilder.newClient();
    URI expectedTargetUri = new URI("http://www.dictionaryapi.com/api/v1/references/thesaurus/xml/"+VALID_WORD+"?key=b5d05597-a001-4ffb-92cd-84225c0e2c56");

    //when
    WebTarget webTarget = merriamWebsterThesaurusImpl.getWebTarget(client, VALID_WORD);

    //then
    assertThat(webTarget).isNotNull();
    assertThat(webTarget.getUri()).isEqualTo(expectedTargetUri);
  }

  @Test
  public void testGetTheSaurus() throws Exception {
    //when
    Object responseValid = merriamWebsterThesaurusImpl.getTheSaurus("valid");

    //then
    assertThat(responseValid).isNotNull();
  }
}