package com.epam;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.List;

public class RestAuthorTest {
    public static final int HTTP_CREATED_AUTHOR = 201;
    public static final int HTTP_OK = 200;
    public static final int HTTP_DELETE = 204;
    public static final int HTTP_ERROR = 404;
    private RestAuthor restAuthor = new RestAuthor();
    private Author author = new Author();
    private Response response;


    public void createAuthor() {
        author.setAuthorId(2847743);
        author.setAuthorName(new Author.Name("Iryna", "Lysechko"));
        author.setNationality("Ukrainian");
        author.setBirth(new Author.Birth("1997-05-14", "Ukraine", "Lviv"));
        author.setAuthorDescription("Starter author");
    }

    //Add new author, if add status code = 201
    @Test
    public void createNewAuthor_whenCreated_HttpCodeSuccess() {
        createAuthor();
        response = restAuthor.createJsonAuthor(author);
        Assert.assertEquals(HTTP_CREATED_AUTHOR, response.getStatus());
    }

    //Get author with existing ID - positive test case
    @Test
    public void getAuthorWithExistingId_serviceCodeSuccess() {
        response = restAuthor.getJsonAuthor(2847743);
        Assert.assertEquals(HTTP_OK, response.getStatus());
    }

    //Get author with not existing ID - negative test case
    @Test
    public void getAuthorWithInvalidID_ServiceCode_Error() {
        response = restAuthor.getJsonAuthor(1);
        Assert.assertEquals(HTTP_ERROR, response.getStatus());
    }

    //Get list of all authors
    @Test
    public void getListOfAllAuthor() {
        List<Author> authorList = restAuthor.getAllAuthor();
        for (Author author : authorList) {
            System.out.println(author);
        }
        Assert.assertEquals(10, authorList.size());
    }

    //Update author name
    @Test
    public void updateAndGetAuthor() {
        author.setAuthorId(2847743);
        author.setAuthorName(new Author.Name("Olena", "Lysechko"));
        author.setNationality("Italian");
        author.setBirth(new Author.Birth("1997-05-14", "Ukraine", "Lviv"));
        author.setAuthorDescription("Starter author");

        response = restAuthor.updateExistingAuthor(author);
        Author author = response.readEntity(Author.class);
        System.out.println(author.getAuthorName() + "" + ". Nationality is: " + author.getNationality());
        Assert.assertEquals(HTTP_OK, response.getStatus());
    }

    //Delete author - status code 204
    @Test
    public void deleteAuthor_ifRequestCorrect_successStatusCode() {
        response = restAuthor.deleteAuthor(2847743);
        Assert.assertEquals(HTTP_DELETE, response.getStatus());
    }

}