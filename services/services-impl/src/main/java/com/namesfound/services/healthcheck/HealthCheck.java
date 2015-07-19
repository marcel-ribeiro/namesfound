package com.namesfound.services.healthcheck;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.springframework.stereotype.Service;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Service
@Path("healthcheck")
public class HealthCheck {
  @GET
  public String doesItWorks() {
    return "It works!";
  }
}