package com.epam.client;

import com.epam.entity.Author;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static com.epam.constants.UrlConstants.*;

public class RestAuthor {
    private Client client = ClientBuilder.newClient();

    public Response getJsonAuthor(int id) {
        return client
                .target(BASE_URI)
                .path(String.format(GET_AUTHOR, id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }

    public Response createJsonAuthor(Author author) {
        return client
                .target(BASE_URI)
                .path(CREATE_AUTHOR)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(author, MediaType.APPLICATION_JSON_TYPE));
    }

    public Response getAllAuthor() {
        return client
                .target(BASE_URI)
                .path(GET_AUTHORS)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }
    public Response getAllAuthorWithCustomSize(int size){
        return client
                .target(BASE_URI)
                .path(GET_AUTHORS)
                .queryParam(SIZE, size)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

    }

    public Response updateExistingAuthor(Author author) {
        return client
                .target(BASE_URI)
                .path(UPDATE_AUTHOR)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(author, MediaType.APPLICATION_JSON_TYPE));
    }

    public Response deleteAuthor(int id) {
        return client
                .target(BASE_URI)
                .path(String.format(DELETE_AUTHOR, id))
                .request()
                .delete();
    }


}
