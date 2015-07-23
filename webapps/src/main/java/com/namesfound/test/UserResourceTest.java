package com.namesfound.test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.namesfound.clients.merriamwebster.MerriamWebsterThesaurusImpl;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author marcel-serra.ribeiro on 22/07/2015.
 */
public class UserResourceTest {

  private static final Logger LOG = LoggerFactory.getLogger(MerriamWebsterThesaurusImpl.class);

  public static void main(String[] args) {
    UserResourceTest userResourceTest = new UserResourceTest();
    userResourceTest.testUserResourceClientString();
  }

  private void testUserResourceClientString() {
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
      //      String readEntity = response.readEntity(String.class);
      InputStream readEntityInputStream = response.readEntity(InputStream.class);
      //      LOG.info(readEntity);

      List<User> users = unmarshall(readEntityInputStream);

      LOG.info(users.toString());
    }
    catch (Exception e) {
      LOG.warn("Not possible to retrieve the users: {}",
          target.getUri(), e);
    }
    finally {
      client.close();
    }
  }

  private static AnnotationConfigApplicationContext getContext() {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(TestConfig.class);
    ctx.refresh();
    return ctx;
  }

  public static List<User> unmarshall(InputStream input) {
    XmlMapper mapper = new XmlMapper();
    List<User> asList = null;
    try {
      asList = mapper.readValue(input, List.class);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    LOG.info(asList.toString());

    return asList;
  }

}