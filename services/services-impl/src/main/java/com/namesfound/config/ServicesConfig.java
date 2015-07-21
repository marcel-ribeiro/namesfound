package com.namesfound.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.namesfound.services.healthcheck.HealthCheck;
import com.namesfound.services.synonyms.config.SynonymsConfig;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Configuration
@Import({ HealthCheck.class, SynonymsConfig.class})
public class ServicesConfig {
}
