package com.epam.client;

import com.epam.BaseTest;
import com.epam.entity.Genre;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;

import static com.epam.constants.CodeConstants.*;

public class RestGenreTest extends BaseTest {

    @Test
    public void getAllGenresOfSpecialAuthorTest() {

        Response response = restGenre.getAllGenresOfSpecialAuthor(6126, "desc");
        Assert.assertEquals(HTTP_200, response.getStatus());

        List<Genre> bookList = response.readEntity(new GenericType<List<Genre>>() {
        });
        for (Genre genre : bookList) {
            System.out.println(genre);
        }
    }
}