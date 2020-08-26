package com.epam.client;

import com.epam.BaseTest;
import com.epam.entity.Book;
import org.testng.*;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;

import static com.epam.constants.CodeConstants.*;

public class RestBookAuthorTest extends BaseTest {

    @Test
    public void getAllBooksOfSpecialAuthorInSpecialGenreTest() {
        Response response = restBook.getAllBooksOfSpecialAuthorInSpecialGenre(1408, 5033);
        Assert.assertEquals(response.getStatus(), HTTP_200);
    }

    //query string parameter
    @Test(groups = { "positive" })
    public void searchForBooksByBookNameTest() {
        final int listSize = 5;

        Response response = restBook.searchByBookName("Excepturi non odio");
        Assert.assertEquals(response.getStatus(), HTTP_200);

        List<Book> bookList = response.readEntity(new GenericType<List<Book>>() {
        });
        Assert.assertEquals(bookList.size(), listSize);
    }

    //Negative test case
    @Test (groups = "negative")
    public void getAllBookOfSpecificGenreTest() {
        final String error_message = "Not Found";

        Response response = restBook.getAllBookOfSpecificGenre(12);
        Assert.assertEquals(response.getStatus(), HTTP_404);

        Response.StatusType message = response.getStatusInfo();
        Assert.assertEquals(message.getReasonPhrase(), error_message);
    }
}