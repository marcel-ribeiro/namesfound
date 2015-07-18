package com.namesfound.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Configuration
@ComponentScan({"com.namesfound.clients.merriamwebster"})
public class ClientsConfiguration {
}
