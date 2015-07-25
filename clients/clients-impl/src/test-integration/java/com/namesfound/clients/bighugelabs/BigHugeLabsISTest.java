package com.namesfound.clients.bighugelabs;

import com.namesfound.clients.bighugelabs.config.BigHugeLabsConfig;
import com.namesfound.clients.helpers.config.ClientsHelpersConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author marcel-serra.ribeiro on 24/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BigHugeLabsConfig.class, ClientsHelpersConfig.class })
public class BigHugeLabsISTest {
  private static final String VALID_WORD = "love";

  @Autowired
  private BigHugeLabsImpl bigHugeLabsImpl;



}