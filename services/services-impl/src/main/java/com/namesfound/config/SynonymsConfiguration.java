package com.namesfound.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author marcel-serra.ribeiro on 13/07/2015.
 */
@Configuration
@ComponentScan(basePackages = {"com.namesfound.services.synonyms"})
public class SynonymsConfiguration {
}
