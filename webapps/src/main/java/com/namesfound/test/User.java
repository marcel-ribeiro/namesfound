package com.namesfound.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY // mandatory for serialization
)
public class User {

  private final String firstname;
  private final String lastname;

  @JsonCreator
  public User(@JsonProperty("firstname") String firstname,
      @JsonProperty("lastname") String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }
}
