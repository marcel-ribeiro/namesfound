package com.namesfound.domain.synonyms;

import java.util.List;

/**
 * @author marcel-serra.ribeiro on 13/07/2015.
 */

public class Word {
  private String word;
  private List<String> synonyms;
  private List<String> relatedWords;
  private List<String> antonyms;
  private List<String> nearAntonyms;
  private List<String> idiomaticPhrases;
  private List<String> conciseDefinitions;
  private List<String> examples;
  private List<String> spellingSuggestions;

  /**
   * Constructor with no arguments
   */
  public Word() {
  }

  /**
   * Description:  Constructor with all the fields
   *
   * @param word the word
   * @param synonyms the list of synonyms
   */
  public Word(String word, List<String> synonyms) {
    this.word = word;
    this.synonyms = synonyms;
  }

  /**
   * returns the word
   * @return word
   */
  public String getWord() {
    return word;
  }

  /**
   * sets the word
   * @param word the word
   */
  public void setWord(String word) {
    this.word = word;
  }

  /**
   * returns the list of synonyms
   * @return synonyms
   */
  public List<String> getSynonyms() {
    return synonyms;
  }

  /**
   * sets the list of synonyms
   * @param synonyms the list of synonyms
   */
  public void setSynonyms(List<String> synonyms) {
    this.synonyms = synonyms;
  }
}
