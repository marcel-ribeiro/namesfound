package com.namesfound.application;

import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.namesfound.services.synonyms.SynonymsServiceImpl;

/**
 * @author marcel-serra.ribeiro on 11/07/2015.
 */
public class ApplicationConfiguration extends ResourceConfig{
  private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);

  public ApplicationConfiguration() {
    Set<Class<?>> services = new HashSet<>();
    services.add(SynonymsServiceImpl.class);
    LOG.info("Registering the following services: {}", services);

    registerClasses(services);
  }
}
