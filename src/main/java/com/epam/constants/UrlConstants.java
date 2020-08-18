package com.epam.constants;

public class UrlConstants {

    public static final String BASE_URI = "http://localhost:8080/";

    // AUTHORS
    public static final String GET_AUTHOR = "/api/library/author/%s";
    public static final String GET_AUTHORS = "/api/library/authors";
    public static final String CREATE_AUTHOR = "/api/library/author";
    public static final String UPDATE_AUTHOR = "/api/library/author";
    public static final String DELETE_AUTHOR = "/api/library/author/%s";

    // BOOKS
    public static final String SEARCH_BOOKS = "/api/library/books/search";
    public static final String GET_BOOKS_BY_GENRE = "/api/library/genre/%s/books";
    public static final String GET_BOOKS_BY_AUTHOR_AND_GENRE = "/api/library/author/%s/genre/%s/books";

    // QUERY PARAMETERS
    public static final String ORDER_TYPE = "orderType";
    public static final String Q = "q";
    public static final String SIZE = "size";

    // GENRE
    public static final String GET_GENRES_BY_AUTHOR = "/api/library/author/%s/genres";

}
