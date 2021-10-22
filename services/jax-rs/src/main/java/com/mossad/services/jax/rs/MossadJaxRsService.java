package com.mossad.services.jax.rs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/message")

public class MossadJaxRsService {

    @Path("hi")
    @GET
    @Produces(TEXT_PLAIN)
    public String getMsg() {
        return "OKI";
    }
}