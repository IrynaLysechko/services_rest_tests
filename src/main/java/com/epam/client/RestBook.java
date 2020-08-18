package com.epam.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.epam.constants.UrlConstants.*;

public class RestBook {
    Client client = ClientBuilder.newClient();

    public Response getAllBooksOfSpecialAuthorInSpecialGenre(int authorID, int genreId) {
        return client
                .target(BASE_URI)
                .path(String.format(GET_BOOKS_BY_AUTHOR_AND_GENRE, authorID, genreId))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }

    public Response searchByBookName(String bookName) {
        return client
                .target(BASE_URI)
                .path(SEARCH_BOOKS)
                .queryParam(Q, bookName)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }

    public Response getAllBookOfSpecificGenre(int genre) {
        return client
                .target(BASE_URI)
                .path(String.format(GET_BOOKS_BY_GENRE, genre))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }

}
