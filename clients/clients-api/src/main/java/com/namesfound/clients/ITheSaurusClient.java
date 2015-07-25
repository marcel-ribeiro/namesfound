package com.namesfound.clients;

import com.namesfound.clients.bighugelabs.domain.Word;

/**
 * @author marcel-serra.ribeiro on 17/07/2015.
 */
public interface ITheSaurusClient {
  Word getTheSaurus(final String wordSearch);
}
