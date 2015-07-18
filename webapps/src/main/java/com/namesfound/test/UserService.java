package com.namesfound.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Service
class UserService {
  public List<User> listAll() {
    return Arrays.asList(new User("Sandro", "Mancuso"), new User("Robert", "Martin"));
  }
}