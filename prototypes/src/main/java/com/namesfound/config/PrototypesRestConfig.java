package com.namesfound.config;

import com.namesfound.test.UserResource;
import com.namesfound.test.CustomerService;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@ApplicationPath("prototype")
public class PrototypesRestConfig extends ResourceConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(PrototypesRestConfig.class);

  public PrototypesRestConfig() {
    Set<Class<?>> services = new HashSet<>();
    services.add(UserResource.class);
    services.add(CustomerService.class);

    LOGGER.info("Registering the following services: {}", services);

    registerClasses(services);
  }
}