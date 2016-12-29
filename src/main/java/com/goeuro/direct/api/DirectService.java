package com.goeuro.direct.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by segr on 21.12.16.
 */
@Path("")
public interface DirectService {
    @GET
    @Path("/direct")
    @Produces(MediaType.APPLICATION_JSON)
    DirectConnectionResult checkDirectConnection(@BeanParam DirectConnectionRequest request);
}
