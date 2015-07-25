package com.namesfound.services.synonyms;

import com.namesfound.domain.synonyms.Word;
import com.namesfound.services.IRestServicesPath;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author marcel-serra.ribeiro on 13/07/2015.
 */
@Path(IRestServicesPath.SYNONYMS_ROOT)
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface ISynonymsService {

  @GET
  @Path(IRestServicesPath.SYNONYMS_GET_SYNONYMS)
  List<String> getSynonyms(
      @PathParam(IRestServicesPath.WORD)
      @NotNull
      final String word);

  @GET
  @Path(IRestServicesPath.SYNONYMS_GET_WORD)
  Word getWord(
      @PathParam(IRestServicesPath.WORD)
      @NotNull
      final String word);


}
