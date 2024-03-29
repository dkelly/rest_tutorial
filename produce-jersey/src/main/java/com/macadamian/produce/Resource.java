package com.macadamian.produce;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
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

    @POST
    @Path("fruits")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addFruit(Fruit f) {
        Storage.instance().addFruit(f);
    }

    @PUT
    @Path("fruits/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addFruit(@PathParam("id") int id, Fruit f) {
        Storage.instance().updateFruit(id, f);
    }

    @GET
    @Path("purchases")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Purchase> allPurchases() {
        return Storage.instance().allPurchases();
    }

    @POST
    @Path("purchases")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPurchase(Purchase p) {
        Storage.instance().addPurchase(p);
    }
}
