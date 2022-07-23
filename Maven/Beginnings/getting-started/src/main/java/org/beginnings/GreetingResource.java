package org.beginnings;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class GreetingResource {
    public static final String TOKEN = "dev";

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello " + UUID.randomUUID().toString() + "!";
    }

    @GET
    @Path("/html/{id}/details")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("id") String id) {
        return "Hello " + id + "!";
    }

    @POST
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addHello(
            @HeaderParam("token") String header,
            @QueryParam("token") String name
    ) {
        String token = header != null ? header : name;

        if(!TOKEN.equals(token)) {
            throw new RuntimeException("Unauthorized!");
        }

        return "<b>Text</b>";
    }
}