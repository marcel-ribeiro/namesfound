package com.namesfound.clients.merriamwebster;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Component;

import com.namesfound.domain.synonyms.Word;

/**
 * @author marcel-serra.ribeiro on 17/07/2015.
 */
@Component
public class MerriamWebsterThesaurusImpl implements IMerriamWebsterThesaurus {
  @Override
  public Word getWord(final String wordSearch) {
    ClientConfig clientConfig = new ClientConfig();
//    clientConfig.register(JacksonFeature.class);

    Client client = ClientBuilder.newClient(clientConfig);

    WebTarget webTarget = client.target(
        "http://localhost:8888/demo-rest-spring-jersey-tomcat-mybatis-0.0.1-SNAPSHOT/podcasts/2");

    Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON);

    Response response = request.get();
//    Assert.assertTrue(response.getStatus() == 200);

    return null;
  }
}
