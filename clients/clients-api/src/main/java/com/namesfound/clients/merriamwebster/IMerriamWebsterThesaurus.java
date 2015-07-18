package com.namesfound.clients.merriamwebster;

import org.springframework.stereotype.Component;

import com.namesfound.domain.synonyms.Word;

/**
 * @author marcel-serra.ribeiro on 17/07/2015.
 */
@Component
public interface IMerriamWebsterThesaurus {
  public Word getWord(final String wordSearch);
}
