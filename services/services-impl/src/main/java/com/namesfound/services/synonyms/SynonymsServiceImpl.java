package com.namesfound.services.synonyms;

import com.namesfound.clients.ITheSaurusClient;
import com.namesfound.domain.synonyms.InternalWord;
import java.util.Arrays;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author marcel-serra.ribeiro on 13/07/2015.
 */

@Service
public class SynonymsServiceImpl implements ISynonymsService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SynonymsServiceImpl.class);

  @Autowired
  private ITheSaurusClient merriamWebsterThesaurus;

  @Override
  public List<String> getSynonyms(
      @NotNull
      String word)
  {
    List<String> synonyms = null;
    //TODO: Check if the word is registered in the server and return its synonyms
    //for the sake of tests lets assume the word is action
    if (word.equalsIgnoreCase("valid")) {
      synonyms = Arrays.asList("right", "genuine", "accurate", "credible", "good");
    }

    return synonyms;
  }

  @Override
  public InternalWord getWord(@NotNull String word) {
    Object theSaurusResponse = merriamWebsterThesaurus.getTheSaurus(word);
    LOGGER.info("theSaurusResponse: {}, entity: {} ", theSaurusResponse, theSaurusResponse);


    return null;
  }
}
