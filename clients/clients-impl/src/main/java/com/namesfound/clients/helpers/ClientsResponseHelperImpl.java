package com.namesfound.clients.helpers;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

/**
 * @author marcel-serra.ribeiro on 21/07/2015.
 */
@Component
public class ClientsResponseHelperImpl implements IClientsResponseHelper {
  @Override
  public boolean isValidContentType(Response response) {
    try {
      return MediaType.valueOf(response.getHeaderString(HttpHeaders.CONTENT_TYPE)) != null;
    }catch (IllegalArgumentException e){
      return false;
    }
  }

  @Override
  public void overrideResponseContentType(Response response, MediaType mediaType) {
    response.getHeaders().putSingle(HttpHeaders.CONTENT_TYPE, mediaType);
  }
}
