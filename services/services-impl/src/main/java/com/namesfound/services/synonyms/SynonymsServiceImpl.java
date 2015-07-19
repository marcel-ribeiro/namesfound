package com.namesfound.services.synonyms;

import com.namesfound.clients.merriamwebster.IMerriamWebsterThesaurus;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namesfound.domain.synonyms.Word;

/**
 * @author marcel-serra.ribeiro on 13/07/2015.
 */

@Service
public class SynonymsServiceImpl implements ISynonymsService {

  @Autowired
  private IMerriamWebsterThesaurus merriamWebsterThesaurus;

  @Override
  public List<String> getSynonyms(@NotNull String word) {
    List<String> synonyms = null;
    //TODO: Check if the word is registered in the server and return its synonyms
    //for the sake of tests lets assume the word is action
    if(word.equalsIgnoreCase("valid")){
      synonyms = Arrays
          .asList("right", "genuine", "accurate", "credible", "good");
    }


    return synonyms;
  }

  @Override
  public Word getWord(@NotNull String word) {
    return merriamWebsterThesaurus.getWord(word);
  }
}
