package com.epam.client;

import com.epam.BaseTest;
import com.epam.entity.Author;
import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.constants.CodeConstants.*;

public class RestAuthorTest extends BaseTest {

    // Use Stream API to choose only author id.
    // If such id present in database, forbidden create author
    @BeforeClass(alwaysRun = true)
    public static void createNewAuthor() {
        final int authorID = 4123;
        Response response = restAuthor.getAllAuthorWithCustomSize(50);
        Assert.assertEquals(response.getStatus(), HTTP_200);

        List<Author> authorList = response.readEntity(new GenericType<List<Author>>() {
        });

        List<Integer> integerList = authorList.stream().map(Author::getAuthorId).collect(Collectors.toList());

        for (Integer listId : integerList) {
            if (listId == authorID) {
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

    @Test(groups = { "positive" })
    public void createNewAuthor_whenCreated_HttpCodeSuccess() {
        Response response = restAuthor.createJsonAuthor(author);
        Assert.assertEquals(response.getStatus(), HTTP_201);

        Author authorResponse = response.readEntity(Author.class);
        Assert.assertEquals(authorResponse, author, "Authors are not equals");

        Response responseDelete = restAuthor.deleteAuthor(author.getAuthorId());
        Assert.assertEquals(responseDelete.getStatus(), HTTP_204, "Cannot delete author");
    }

    //Get author with existing ID - positive test case
    @Test(groups = { "positive" })
    public void getAuthorWithExistingId_serviceCodeSuccess() {
        Response createResponse = restAuthor.createJsonAuthor(author);
        Assert.assertEquals(createResponse.getStatus(), HTTP_201);

        Response getAuthorResponse = restAuthor.getJsonAuthor(author.getAuthorId());
        Assert.assertEquals(getAuthorResponse.getStatus(), HTTP_200);

        Author responseAuthor = getAuthorResponse.readEntity(Author.class);
        Assert.assertEquals(responseAuthor.getAuthorId(), author.getAuthorId());

        Response response = restAuthor.deleteAuthor(author.getAuthorId());
        Assert.assertEquals(response.getStatus(), HTTP_204);
    }

    //Get author with not existing ID - negative test case
    @Test(groups = "negative")
    public void getAuthorWithInvalidID_ServiceCode_Error() {
        final String errorMessage = "Not Found";

        Response response = restAuthor.getJsonAuthor(1);
        Assert.assertEquals(response.getStatus(), HTTP_404);

        Response.StatusType responseMessage = response.getStatusInfo();
        Assert.assertEquals(responseMessage.getReasonPhrase(), errorMessage);
    }

    //Get list of all authors
    @Test(groups = { "positive" })
    public void getListOfAllAuthor() {
        final int defaultAuthorListSize = 10;

        Response response = restAuthor.getAllAuthor();
        Assert.assertEquals(response.getStatus(), HTTP_200);

        List<Author> authorList = response.readEntity(new GenericType<List<Author>>() {
        });
        Assert.assertEquals(authorList.size(), defaultAuthorListSize);
    }

    //Update author name
    @Test(groups = { "positive" })
    public void update_Get_DeleteAuthor() {
        Response createResponse = restAuthor.createJsonAuthor(author);
        Assert.assertEquals(createResponse.getStatus(), HTTP_201);

        Author authorResponse = createResponse.readEntity(Author.class);
        authorResponse.setAuthorName(new Author.Name("Olena", "Lysechko"));

        Response response = restAuthor.updateExistingAuthor(authorResponse);
        Assert.assertEquals(response.getStatus(), HTTP_200, "Cannot update existing author");

        Author responseAuthor = response.readEntity(Author.class);
        Assert.assertEquals(authorResponse, responseAuthor);

        Response responseDelete = restAuthor.deleteAuthor(author.getAuthorId());
        Assert.assertEquals(responseDelete.getStatus(), HTTP_204, "Cannot delete author");
    }

    @Test(groups = { "positive" })
    public void deleteAuthor_ifRequestCorrect_successStatusCode() {
        final String ERROR_MESSAGE = "No Content";

        Response responseCreate = restAuthor.createJsonAuthor(author);
        Assert.assertEquals(responseCreate.getStatus(), HTTP_201, "Cannot create author");

        Response responseDelete = restAuthor.deleteAuthor(author.getAuthorId());
        Assert.assertEquals(responseDelete.getStatus(), HTTP_204, "Cannot delete author");

        Response.StatusType responseMessage = responseDelete.getStatusInfo();
        Assert.assertEquals(responseMessage.getReasonPhrase(), ERROR_MESSAGE);
    }
}