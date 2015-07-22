package com.namesfound.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author marcel-serra.ribeiro on 22/07/2015.
 *
 * http://localhost:8080/namesfound/rest/xml/customer/999
 */
@Path("/xml/customer")
public class XMLService {

  @GET
  @Path("/{pin}")
  @Produces(MediaType.APPLICATION_XML)
  public Customer getCustomerInXML(@PathParam("pin") int pin) {

    Customer customer = new Customer();
    customer.setName("mkyong");
    customer.setPin(pin);

    return customer;

  }

}