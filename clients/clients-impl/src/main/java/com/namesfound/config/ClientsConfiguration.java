package com.namesfound.config;

import com.namesfound.clients.bighugelabs.config.BigHugeLabsConfig;
import com.namesfound.clients.helpers.config.ClientsHelpersConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Configuration
@Import({ BigHugeLabsConfig.class, ClientsHelpersConfig.class })
public class ClientsConfiguration {
}
