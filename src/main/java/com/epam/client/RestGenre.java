package com.epam.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.epam.constants.UrlConstants.*;

public class RestGenre {
    Client client = ClientBuilder.newClient();

    public Response getAllGenresOfSpecialAuthor(int authorID, String orderType) {
        return client
                .target(BASE_URI)
                .path(String.format(GET_GENRES_BY_AUTHOR, authorID))
                .queryParam(ORDER_TYPE, orderType)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }
}
