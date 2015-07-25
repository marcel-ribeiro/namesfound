package com.namesfound.config;

import com.namesfound.test.TestConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Configuration
@Import({ TestConfig.class })
public class PrototypesConfig {
}
