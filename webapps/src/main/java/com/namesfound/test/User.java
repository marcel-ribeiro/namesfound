package com.namesfound.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@XmlRootElement(name = "customer")
public class User {
  private String firstname;
  private String lastname;

  public User(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public User() {
  }

  @XmlElement
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  @XmlElement
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}
