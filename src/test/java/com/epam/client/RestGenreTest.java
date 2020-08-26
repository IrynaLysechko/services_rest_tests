package com.epam.client;

import com.epam.BaseTest;
import com.epam.entity.Genre;
import org.testng.*;
import org.testng.annotations.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;

import static com.epam.constants.CodeConstants.*;

public class RestGenreTest extends BaseTest {

    @Test
    public void getAllGenresOfSpecialAuthorTest() {
        Response response = restGenre.getAllGenresOfSpecialAuthor(6126, "desc");
        Assert.assertEquals(response.getStatus(), HTTP_200);
    }
}