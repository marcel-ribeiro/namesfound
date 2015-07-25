package com.namesfound.clients.merriamwebster.converter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author marcel-serra.ribeiro on 23/07/2015.
 */
public class MerriamWebsterConverter {
  private static final Logger LOGGER = LoggerFactory.getLogger(MerriamWebsterConverter.class);

  public static Object unmarshall(InputStream input) {
    XmlMapper mapper = new XmlMapper();
    Object result = null;
    try {
      result = mapper.readValue(input, Object.class);
      LOGGER.info(result.toString());
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

}
