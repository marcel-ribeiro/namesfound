package com.namesfound.clients.bighugelabs.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.namesfound.clients.bighugelabs.domain.Word;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author marcel-serra.ribeiro on 23/07/2015.
 */
public class BigHugeLabsConverter {
  private static final Logger LOG = LoggerFactory.getLogger(BigHugeLabsConverter.class);

  public static Word unmarshallJSON(InputStream input) {
    ObjectMapper mapper = new ObjectMapper();
    Word result = null;
    try {
      result = mapper.readValue(input, Word.class);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    LOG.info(result.toString());

    return result;
  }

}
