package com.namesfound.clients.helpers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author marcel-serra.ribeiro on 21/07/2015.
 */
public interface IClientsResponseHelper {

  /**
   * Helper method that checks whether the media type is valid or not
   *
   * @param response response
   * @return boolean
   */
  boolean isValidContentType(Response response);

  /**
   * Helper method that facilitates overriding the media type on the response
   * To be used mostly when the service provides an invalid content type
   *
   * @param response response
   * @param mediaType media type
   */
  void overrideResponseContentType(Response response, MediaType mediaType);
}
