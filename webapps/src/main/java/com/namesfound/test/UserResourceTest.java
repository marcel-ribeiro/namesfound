package com.namesfound.test;

import com.namesfound.clients.merriamwebster.MerriamWebsterThesaurusImpl;
import java.io.File;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author marcel-serra.ribeiro on 22/07/2015.
 */
public class UserResourceTest {

  private static final Logger LOG = LoggerFactory.getLogger(MerriamWebsterThesaurusImpl.class);

  public static void main(String[] args) {
    UserResourceTest userResourceTest = new UserResourceTest();
    userResourceTest.testUserResourceClient();
  }

  private void testUserResourceClient() {
    ClientConfig config = new ClientConfig();

    Client client = ClientBuilder.newClient(config);

    WebTarget target = client.target("http://localhost:8080");
    target = target.path("namesfound");
    target = target.path("rest");
    target = target.path("users");
    target = target.path("xml");
    //    target = target.queryParam(keyName, keyValue);

    try

    {
      Response response = target.request().get();
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }

      response.bufferEntity();
      String readEntity = response.readEntity(String.class);
      LOG.info(readEntity);
      String output = response.getEntity().toString();
      LOG.info(output);
    }
    catch (Exception e) {
      LOG.warn("The Merriam Webster client was not able to retrieve thesaurus with the final URL used: {}",
          target.getUri(), e);
    }
    finally {
      client.close();
    }
  }

  private void testConversion() {
    JAXBContext jc = null;
    try {
      jc = JAXBContext.newInstance(User.class);

      Unmarshaller unmarshaller = jc.createUnmarshaller();
      File xml = new File("src/forum14734741/input.xml");
      User customer = (User) unmarshaller.unmarshal(xml);

      Marshaller marshaller = jc.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//      marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
//      marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
      marshaller.marshal(customer, System.out);
    }
    catch (JAXBException e) {
      e.printStackTrace();
    }
  }
}