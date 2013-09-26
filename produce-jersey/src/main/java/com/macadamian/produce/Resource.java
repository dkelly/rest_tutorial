package com.macadamian.produce;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
public class Resource {
    @GET
    @Path("fruits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> allFruits() {
        return Storage.instance().allFruits();
    }

    @GET
    @Path("fruits/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fruit getFruit(@PathParam("id") int id) {
        return Storage.instance().getFruit(id);
    }

    @DELETE
    @Path("fruits/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fruit removeFruit(@PathParam("id") int id) {
        return Storage.instance().removeFruit(id);
    }
}
