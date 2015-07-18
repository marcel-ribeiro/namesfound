package com.namesfound.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Path("healthcheck")
public class HealthCheck {
  @GET
  public String doesItWorks() {
    return "It works!";
  }
}