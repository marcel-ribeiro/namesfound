package com.namesfound.services.synonyms;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author marcel-serra.ribeiro on 15/07/2015.
 */
public class SynonymsServiceImplTest extends TestCase {

  private SynonymsServiceImpl synonymsServiceImpl= new SynonymsServiceImpl();

  private static final String VALID_WORD = "valid";
  private static final String INVALID_WORD = "invalid";

  private static final List<String> SYNONYMS_VALID_WORD = Arrays
      .asList(new String[] { "right", "genuine", "accurate", "credible", "good" });


  @Test
  public void testGetSynonymsValidWord() throws Exception {
    //given

    //when
    List<String> validSynonyms = synonymsServiceImpl.getSynonyms(VALID_WORD);

    //then
    assertThat(validSynonyms).isEqualTo(SYNONYMS_VALID_WORD);
  }

  @Test
  public void testGetSynonymsInvalidWord() throws Exception {
    //given
    String invalidWord = "invalid";

    //when
    List<String> validSynonyms = synonymsServiceImpl.getSynonyms(INVALID_WORD);

    //then
    assertThat(validSynonyms).isNull();
  }

  @Test
  public void testGetWord() throws Exception {
    //TODO: implement tests
    fail("Not implemented yet");
  }
}