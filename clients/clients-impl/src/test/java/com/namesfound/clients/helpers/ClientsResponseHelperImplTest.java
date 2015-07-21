package com.namesfound.clients.helpers;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import javax.ws.rs.core.*;
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
    MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
    headers.putSingle(HttpHeaders.CONTENT_TYPE, "invalidType");
    Response response = getBasicResponse(headers);

    //When
    boolean isValidContentType = clientsResponseHelper.isValidContentType(response);

    //Then
    assertThat(isValidContentType).isFalse();
  }


  @Test
  public void testIsValidContentTypeWithValid() throws Exception {
    //Given
    MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
    headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);
    Response response = getBasicResponse(headers);

    //When
    boolean isValidContentType = clientsResponseHelper.isValidContentType(response);

    //Then
    assertThat(isValidContentType).isTrue();
  }

  @Test
  public void testOverrideResponseContentType() throws Exception {

  }

  private Response getBasicResponse(MultivaluedMap<String, Object> headers) {
    Response responseMock = Mockito.mock(Response.class);
    Mockito.when(responseMock.getHeaders()).thenReturn(headers);
    for (Map.Entry<String, List<Object>> entry : headers.entrySet()) {
      Mockito.when(responseMock.getHeaderString(entry.getKey())).thenReturn(entry.getValue().toString());
    }



    return responseMock;
  }
}