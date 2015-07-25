package com.namesfound.test;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Path("users")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
@Component
public class UserResource {

  @Autowired
  private UserService userService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> listAllUsers() {
    return userService.listAll();
  }

  @GET
  @Path("xml")
  @Produces(MediaType.APPLICATION_XML)
  public List<User> listAllUsersXml() {
    return userService.listAll();
  }
}
