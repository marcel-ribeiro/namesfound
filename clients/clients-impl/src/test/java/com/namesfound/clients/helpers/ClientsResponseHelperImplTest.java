package com.namesfound.clients.helpers;

import static org.fest.assertions.Assertions.assertThat;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author marcel-serra.ribeiro on 21/07/2015.
 */
public class ClientsResponseHelperImplTest extends TestCase {

  private IClientsResponseHelper clientsResponseHelper = new ClientsResponseHelperImpl();

  @Test
  public void testIsValidContentTypeWithInvalid() throws Exception {
    //Given
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getHeaderString(HttpHeaders.CONTENT_TYPE)).thenReturn("invalidType");

    //When
    boolean isValidContentType = clientsResponseHelper.isValidContentType(response);

    //Then
    assertThat(isValidContentType).isFalse();
  }


  @Test
  public void testIsValidContentTypeWithValid() throws Exception {
    //Given
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getHeaderString(HttpHeaders.CONTENT_TYPE)).thenReturn(MediaType.APPLICATION_XML);

    //When
    MediaType mediaType = MediaType.valueOf(MediaType.APPLICATION_XML);
    boolean isValidContentType = clientsResponseHelper.isValidContentType(response);

    //Then
    assertThat(isValidContentType).isTrue();
  }

  @Test
  public void testOverrideResponseContentType() throws Exception {

  }

}