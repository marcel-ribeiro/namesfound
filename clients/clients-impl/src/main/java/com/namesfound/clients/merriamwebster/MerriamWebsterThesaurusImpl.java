package com.namesfound.clients.merriamwebster;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author marcel-serra.ribeiro on 17/07/2015.
 */
@Component
public class MerriamWebsterThesaurusImpl implements IMerriamWebsterThesaurus {
  private static final Logger LOG = LoggerFactory.getLogger(MerriamWebsterThesaurusImpl.class);

  @Value("${merriamwebster.url}")
  private String url;

  @Value("${merriamwebster.paths}")
  private String[] paths;

  @Value("${merriamwebster.key.parameter.name}")
  private String keyName;

  @Value("${merriamwebster.key.parameter.value}")
  private String keyValue;
//
//  @Autowired
//  private IClientsResponseHelper clientsResponseHelper;

  //  private URI getBaseURI() {
  //    return UriBuilder.fromUri(url + responseType).build();
  //  }

  @Override
  public Object getTheSaurus(final String wordSearch) {
    //final String finalUrl = url + responseType + wordSearch + key;

    ClientConfig config = new ClientConfig();

    Client client = ClientBuilder.newClient(config);

    WebTarget target = getWebTarget(client, wordSearch);

    try {
      Response response = target.request().get();
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }

//      if (!clientsResponseHelper.isValidContentType(response)) {
//        LOG.info("The response from Merriam Webster has an invalid content type, therefore it's been overwritten by: {}",
//            MediaType.APPLICATION_XML_TYPE);
//        clientsResponseHelper.overrideResponseContentType(response, MediaType.APPLICATION_XML_TYPE);
//      }


      response.bufferEntity();
      String readEntity = response.readEntity(String.class);
      LOG.info(readEntity);
      String output = response.getEntity().toString();
      LOG.info(output);
      return response;
    }
    catch (Exception e) {
      LOG.warn("The Merriam Webster client was not able to retrieve thesaurus with the final URL used: {}",
          target.getUri(), e);
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
    target = target.path(wordSearch);
    target = target.queryParam(keyName, keyValue);
    return target;
  }
}
