package com.namesfound.clients.bighugelabs.converter;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * @author marcel-serra.ribeiro on 24/07/2015.
 */
public class BigHugeLabsConverterTest {

  private static final String FILE_NAME_JSON = "bighugelabs/love.json";

  @Test
  public void tesUnmarshallJSON() throws FileNotFoundException {
      // Given
    FileInputStream fileInputStream = getFileInputStream(FILE_NAME_JSON);

    // When
    Object convertedObject = BigHugeLabsConverter.unmarshallJSON(fileInputStream);

    // Then
    assertThat(convertedObject).isNotNull();
  }

  private FileInputStream getFileInputStream(final String fileName) throws FileNotFoundException {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    return new FileInputStream(file);
  }
}