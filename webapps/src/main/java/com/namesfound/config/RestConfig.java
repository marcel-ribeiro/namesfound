package com.namesfound.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@ApplicationPath("api")
public class RestConfig extends ResourceConfig {

  private static final Logger LOG = LoggerFactory.getLogger(RestConfig.class);

  public RestConfig() {
    packages("com.namesfound.test");
    register(JacksonJsonProvider.class);
  }
}