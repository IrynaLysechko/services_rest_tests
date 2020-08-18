package com.epam;

import com.epam.client.RestAuthor;
import com.epam.client.RestBook;
import com.epam.client.RestGenre;
import com.epam.entity.Author;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.constants.CodeConstants.*;

public class BaseTest {
    protected static Author author = new Author();;
    protected static RestAuthor restAuthor;
    protected static RestBook restBook;
    protected static RestGenre restGenre;


    @BeforeClass
    public static void initialize() {
        restAuthor = new RestAuthor();
        restBook = new RestBook();
        restGenre = new RestGenre();
    }

}
