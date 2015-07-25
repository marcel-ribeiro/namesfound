package com.namesfound.clients.bighugelabs;

import com.namesfound.clients.bighugelabs.converter.BigHugeLabsConverter;
import com.namesfound.clients.bighugelabs.domain.Word;
import com.namesfound.clients.helpers.IClientsResponseHelper;
import java.io.InputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author marcel-serra.ribeiro on 17/07/2015.
 */
@Component
public class BigHugeLabsImpl implements IBigHugeLabs {
  private static final Logger LOGGER = LoggerFactory.getLogger(BigHugeLabsImpl.class);

  @Value("${bighugelabs.url}")
  private String url;

  @Value("${bighugelabs.paths}")
  private String[] paths;

  @Value("${bighugelabs.response.format}")
  private String responseFormat;

  @Value("${bighugelabs.key.value}")
  private String keyValue;

  @Autowired
  private IClientsResponseHelper clientsResponseHelper;

  @Override
  public Object getTheSaurus(final String wordSearch) {
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);
    WebTarget target = getWebTarget(client, wordSearch);

    try {
      Response response = target.request().get();
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }

      response.bufferEntity();
      String readEntity = response.readEntity(String.class);
      InputStream responseInputStream = response.readEntity(InputStream.class);
      Word word = BigHugeLabsConverter.unmarshallJSON(responseInputStream);

      LOGGER.info(readEntity);
      String output = response.getEntity().toString();
      LOGGER.info(output);
      return response;
    }
    catch (Exception e) {
      LOGGER.warn("The BigHugeLabs client was not able to retrieve thesaurus with the final URL used: {}", target.getUri(),
          e);
      return null;
    }
    finally {
      client.close();
    }


    //    String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
    //    String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
    //    String htmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);

//    System.out.println(response);
  }

  protected WebTarget getWebTarget(final Client client, final String wordSearch) {
    WebTarget target = client.target(url);
    for (String path : paths) {
      target = target.path(path);
    }
    target = target.path(keyValue);
    target = target.path(wordSearch);
    target = target.path(responseFormat);
    return target;
  }
}
