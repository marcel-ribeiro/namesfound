package com.namesfound.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.namesfound.services.synonyms.SynonymsServiceImpl;

/**
 * @author marcel-serra.ribeiro on 11/07/2015.
 */
@Configuration
public class ApplicationConfiguration extends ResourceConfig{

  public ApplicationConfiguration() {
    System.out.println("Creating resources");
    register(SynonymsServiceImpl.class);
  }
}
