package com.epam;

import com.epam.client.RestAuthor;
import com.epam.client.RestBook;
import com.epam.client.RestGenre;
import com.epam.entity.Author;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    protected static Author author;
    protected static RestAuthor restAuthor;
    protected static RestBook restBook;
    protected static RestGenre restGenre;

    @BeforeSuite(alwaysRun = true)
    public static void initialize() {
        author = new Author();
        restAuthor = new RestAuthor();
        restBook = new RestBook();
        restGenre = new RestGenre();
    }
}
