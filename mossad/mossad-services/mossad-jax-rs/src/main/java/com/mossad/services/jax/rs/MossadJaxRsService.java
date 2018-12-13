package com.mossad.services.jax.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/message")

public class MossadJaxRsService {

    @Path("hi")
    @GET
    @Produces(TEXT_PLAIN)
    public String getMsg()
    {
        return "OKI";
    }
}
