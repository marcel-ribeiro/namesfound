package com.namesfound.clients.merriamwebster.converter;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.FileInputStream;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author marcel-serra.ribeiro on 24/07/2015.
 */
public class MerriamWebsterConverterTest {
  private static final String FILE_NAME = "smart/smart.xml";


  @Ignore("The unmarshalling of XML is not working for this provider")
  @Test
  public void testUnmarshall() throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(FILE_NAME).getFile());
    FileInputStream fileInputStream = new FileInputStream(file);
    Object convertedObject = MerriamWebsterConverter.unmarshall(fileInputStream);

    assertThat(convertedObject).isNotNull();

  }
}