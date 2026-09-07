package com.oracle.helidonapps.productservice.controllers;

import com.oracle.helidonapps.productservice.entities.Category;
import com.oracle.helidonapps.productservice.repository.RepositoryContract;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/api/categories")
public class CategoryController {

    @Inject
    RepositoryContract<Category, Integer> repository;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories() {
        try {
            var all = repository.getAll();
            if (!all.isEmpty()) {
                return Response.ok(all).build();
            } else {
                return Response.status(500, "no categories found..").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategory(@PathParam("id") int id) {
        try {
            var category = repository.get(id);
            if (category != null) {
                return Response.ok(category).build();
            } else {
                return Response.status(500, "no category found..").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCategory(Category category) {
        try {
            var added = repository.add(category);
            if (added != null) {
                return Response
                        .created(new URI("/api/categories/add"))
                        .entity(added)
                        .build();
            } else {
                return Response
                        .status(500)
                        .entity("could not add record")
                        .build();
            }
        } catch (Exception e) {
            return Response
                    .serverError()
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatedCategory(@PathParam("id") int id, Category category) {
        try {
            var updated = repository.update(id, category);
            if (updated != null) {
                return Response.created(new URI("/api/categories/edit/" + String.valueOf(id)))
                        .entity(updated)
                        .build();
            } else {
                return Response.status(500).entity("could not update record").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategory(@PathParam("id") int id) {
        try {
            var deleted = repository.delete(id);
            if (deleted != null) {
                return Response.ok(deleted).build();
            } else {
                return Response.status(500, "no category found..").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

}
