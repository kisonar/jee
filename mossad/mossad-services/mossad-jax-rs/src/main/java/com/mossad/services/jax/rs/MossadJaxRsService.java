package com.mossad.services.jax.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/message")

public class MossadJaxRsService {

    @GET
    public String getMsg()
    {
        return "Hello World !! - Jersey 2";
    }
}
