package com.namesfound.config;

import com.namesfound.services.IRestServicesPath;
import com.namesfound.services.healthcheck.HealthCheck;
import com.namesfound.services.synonyms.SynonymsServiceImpl;
import com.namesfound.test.UserResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@ApplicationPath(IRestServicesPath.ROOT_REST_API)
public class RestConfig extends ResourceConfig {

  private static final Logger LOG = LoggerFactory.getLogger(RestConfig.class);

  public RestConfig() {
    Set<Class<?>> services = new HashSet<>();
    services.add(HealthCheck.class);
    services.add(UserResource.class);
    services.add(SynonymsServiceImpl.class);

    LOG.info("Registering the following services: {}", services);

    registerClasses(services);
//    register(JacksonJsonProvider.class);
  }
}