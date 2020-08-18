package com.epam.client;

import com.epam.BaseTest;
import com.epam.entity.Author;
import org.junit.*;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.constants.CodeConstants.*;


public class RestAuthorTest extends BaseTest {

    // Use Stream API to choose only author id.
    // If such id present in database, forbidden create author
    @BeforeClass
    public static void createNewAuthor() {
        final int authorID = 4123;
        Response response = restAuthor.getAllAuthorWithCustomSize(50);
        Assert.assertEquals(HTTP_200, response.getStatus());

        List<Author> authorList = response.readEntity(new GenericType<List<Author>>() {
        });

        List<Integer> integerList = authorList.stream().map(Author::getAuthorId).collect(Collectors.toList());

        for (Integer integer : integerList) {
            if (integer == authorID) {
                System.out.println("Forbidden use this ID");
                break;
            }
        }
        author.setAuthorId(authorID);
        author.setAuthorName(new Author.Name("Iryna", "Lysechko"));
        author.setNationality("Ukrainian");
        author.setBirth(new Author.Birth("1997-05-14", "Ukraine", "Lviv"));
        author.setAuthorDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
    }

    @Test
    public void createNewAuthor_whenCreated_HttpCodeSuccess() {
        Response response = restAuthor.createJsonAuthor(author);
        Assert.assertEquals(HTTP_201, response.getStatus());

        Author authorResponse = response.readEntity(Author.class);
        Assert.assertEquals("Authors are not equals", author, authorResponse);

        Response responseDelete = restAuthor.deleteAuthor(author.getAuthorId());
        Assert.assertEquals("Cannot delete author", HTTP_204, responseDelete.getStatus());
    }

    //Get author with existing ID - positive test case
    @Test
    public void getAuthorWithExistingId_serviceCodeSuccess() {
        Response createResponse = restAuthor.createJsonAuthor(author);
        Assert.assertEquals(HTTP_201, createResponse.getStatus());

        Response getAuthorResponse = restAuthor.getJsonAuthor(author.getAuthorId());
        Assert.assertEquals(HTTP_200, getAuthorResponse.getStatus());

        Author responseAuthor = getAuthorResponse.readEntity(Author.class);
        Assert.assertEquals(author.getAuthorId(), responseAuthor.getAuthorId());

        Response response = restAuthor.deleteAuthor(author.getAuthorId());
        Assert.assertEquals(HTTP_204, response.getStatus());
    }

    //Get author with not existing ID - negative test case
    @Test
    public void getAuthorWithInvalidID_ServiceCode_Error() {
        final String errorMessage = "Not Found";

        Response response = restAuthor.getJsonAuthor(1);
        Assert.assertEquals(HTTP_404, response.getStatus());

        Response.StatusType responseMessage = response.getStatusInfo();
        Assert.assertEquals(errorMessage, responseMessage.getReasonPhrase());
    }

    //Get list of all authors
    @Test
    public void getListOfAllAuthor() {
        final int defaultAuthorListSize = 10;

        Response response = restAuthor.getAllAuthor();
        Assert.assertEquals(HTTP_200, response.getStatus());

        List<Author> authorList = response.readEntity(new GenericType<List<Author>>() {
        });
        Assert.assertEquals(defaultAuthorListSize, authorList.size());
    }

    //Update author name
    @Test
    public void update_Get_DeleteAuthor() {
        Response createResponse = restAuthor.createJsonAuthor(author);
        Assert.assertEquals(HTTP_201, createResponse.getStatus());

        Author authorResponse = createResponse.readEntity(Author.class);
        authorResponse.setAuthorName(new Author.Name("Olena", "Lysechko"));

        Response response = restAuthor.updateExistingAuthor(authorResponse);
        Assert.assertEquals("Cannot update existing author", HTTP_200, response.getStatus());

        Author responseAuthor = response.readEntity(Author.class);
        Assert.assertEquals(authorResponse, responseAuthor);

        Response responseDelete = restAuthor.deleteAuthor(author.getAuthorId());
        Assert.assertEquals("Cannot delete author", HTTP_204, responseDelete.getStatus());
    }

    @Test
    public void deleteAuthor_ifRequestCorrect_successStatusCode() {
        final String ERROR_MESSAGE = "No Content";

        Response responseCreate = restAuthor.createJsonAuthor(author);
        Assert.assertEquals("Cannot create author", HTTP_201, responseCreate.getStatus());

        Response responseDelete = restAuthor.deleteAuthor(author.getAuthorId());
        Assert.assertEquals("Cannot delete author", HTTP_204, responseDelete.getStatus());

        Response.StatusType responseMessage = responseDelete.getStatusInfo();
        Assert.assertEquals(ERROR_MESSAGE, responseMessage.getReasonPhrase());
    }
}