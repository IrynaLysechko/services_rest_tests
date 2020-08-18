package com.epam.client;

import com.epam.BaseTest;
import com.epam.entity.Book;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;

import static com.epam.constants.CodeConstants.*;

public class RestBookAuthorTest extends BaseTest {

    @Test
    public void getAllBooksOfSpecialAuthorInSpecialGenreTest() {
        Response response = restBook.getAllBooksOfSpecialAuthorInSpecialGenre(1408, 5033);
        Assert.assertEquals(HTTP_200, response.getStatus());

        List<Book> bookList = response.readEntity(new GenericType<List<Book>>() {
        });

        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    //query string parameter
    @Test
    public void searchForBooksByBookNameTest() {
        final int listSize = 5;

        Response response = restBook.searchByBookName("Excepturi non odio");
        Assert.assertEquals(HTTP_200, response.getStatus());

        List<Book> bookList = response.readEntity(new GenericType<List<Book>>() {
        });
        Assert.assertEquals(listSize, bookList.size());
    }

    //Negative test case
    @Test
    public void getAllBookOfSpecificGenreTest() {
        final String error_message = "Not Found";

        Response response = restBook.getAllBookOfSpecificGenre(12);
        Assert.assertEquals(HTTP_404, response.getStatus());

        Response.StatusType message = response.getStatusInfo();
        Assert.assertEquals(error_message, message.getReasonPhrase());
    }
}