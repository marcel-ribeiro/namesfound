package com.namesfound.config;

import static org.fest.assertions.Assertions.assertThat;

import com.namesfound.clients.ITheSaurusClient;
import com.namesfound.clients.helpers.IClientsResponseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author marcel-serra.ribeiro on 25/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ClientsConfiguration.class })
public class ClientsConfigurationTest {
  @Autowired
  private ITheSaurusClient theSaurusClient;

  @Autowired
  private IClientsResponseHelper clientsResponseHelper;

  @Test
  public void shouldLoadContext() {
      // Then
    assertThat(theSaurusClient).isNotNull();
    assertThat(clientsResponseHelper).isNotNull();

  }
}