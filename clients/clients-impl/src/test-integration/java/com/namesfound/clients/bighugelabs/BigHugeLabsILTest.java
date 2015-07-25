package com.namesfound.clients.bighugelabs;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

import com.namesfound.clients.bighugelabs.config.BigHugeLabsConfig;
import com.namesfound.clients.helpers.config.ClientsHelpersConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author marcel-serra.ribeiro on 24/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BigHugeLabsConfig.class, ClientsHelpersConfig.class })
public class BigHugeLabsILTest {
  private static final String VALID_WORD = "love";

  @Autowired
  private BigHugeLabsImpl bigHugeLabsImpl;

  @Test
  public void testGetTheSaurus() throws Exception {
    fail("integration tests should not run");

    // When
    Object responseValid = bigHugeLabsImpl.getTheSaurus(VALID_WORD);

    // Then
    assertThat(responseValid).isNotNull();
  }

}