package com.namesfound.services;

/**
 * @author marcel-serra.ribeiro on 13/07/2015.
 */
public interface IRestServicesPath {
  String WORD = "word";
  String SYNONYMS_ROOT = "/synonyms/";
  String SYNONYMS_GET_SYNONYMS = "/getSynonyms/{"+ IRestServicesPath.WORD+"}";
  String SYNONYMS_GET_WORD = "/getWord/{"+ IRestServicesPath.WORD+"}";


}
