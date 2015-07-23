package com.namesfound.test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.util.List;
import jersey.repackaged.com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author marcel-serra.ribeiro on 23/07/2015.
 */
public class JacksonExampleUsers {
  private static final Logger LOG = LoggerFactory.getLogger(JacksonExampleUsers.class);

  public static void main(String[] args) {

    try {
      jacksonJsonMarshall();
      jacksonXmlMarshall();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void jacksonJsonMarshall() throws JsonParseException, JsonMappingException, IOException
  {
    ObjectMapper mapper = new ObjectMapper();

    List<User> listOfDtos = Lists.newArrayList(new User("John", "Doo"), new User("Mike", "Ross"));
    String jsonArray = mapper.writeValueAsString(listOfDtos);

    List<User> asList = mapper.readValue(jsonArray, List.class);

  }

  private static void jacksonXmlMarshall() throws JsonParseException, JsonMappingException, IOException
  {
//    ObjectMapper mapper = new ObjectMapper();
    XmlMapper mapper = new XmlMapper();

    List<User> listOfDtos = Lists.newArrayList(new User("John", "Doo"), new User("Mike", "Ross"));
    String jsonArray = mapper.writeValueAsString(listOfDtos);
    LOG.info(jsonArray);

    List<User> asList = mapper.readValue(jsonArray, List.class);
    LOG.info(asList.toString());

  }

}
