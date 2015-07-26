package com.namesfound.clients.merriamwebster;

import static org.fest.assertions.Assertions.assertThat;

import com.namesfound.clients.helpers.config.ClientsHelpersConfig;
import com.namesfound.clients.merriamwebster.config.MerriamWebsterConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author marcel-serra.ribeiro on 20/07/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MerriamWebsterConfig.class, ClientsHelpersConfig.class })
public class MerriamWebsterThesaurusImplILTest extends TestCase {

  private static final String VALID_WORD = "merriamwebster";
  @Autowired
  private MerriamWebsterThesaurusImpl merriamWebsterThesaurusImpl;

  @Test
  public void testGetTheSaurus() throws Exception {
    //when
    Object responseValid = merriamWebsterThesaurusImpl.getTheSaurus("merriamwebster");

    //then
    assertThat(responseValid).isNotNull();
  }
}