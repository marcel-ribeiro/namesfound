package com.namesfound.clients.bighugelabs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author marcel-serra.ribeiro on 19/07/2015.
 */
@Configuration
@PropertySource({ "classpath:/bighugelabs.properties" })
@ComponentScan({"com.namesfound.clients.bighugelabs"})
public class BigHugeLabsConfig {
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
