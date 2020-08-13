package com.epam;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class RestAuthor {
    private static final String AUTHOR_URL = "http://localhost:8080/api/library/author";
    private static final String ALL_AUTHOR = "http://localhost:8080/api/library/authors";
    private Client client = ClientBuilder.newClient();

    public Response getJsonAuthor(int id) {
        return client
                .target(AUTHOR_URL)
                .path(String.valueOf(id))
                .request()
                .get();
    }

    public Response createJsonAuthor(Author author) {
        return client
                .target(AUTHOR_URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(author, MediaType.APPLICATION_JSON_TYPE));
    }

    public List<Author> getAllAuthor() {
        return client
                .target(ALL_AUTHOR)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Author>>() {
                });
    }

    public Response updateExistingAuthor(Author author) {
        return client
                .target(AUTHOR_URL)
                .request()
                .put(Entity.entity(author, MediaType.APPLICATION_JSON_TYPE));
    }

    public Response deleteAuthor(int id) {
        return client
                .target(AUTHOR_URL)
                .path(String.valueOf(id))
                .request()
                .delete();
    }


}
