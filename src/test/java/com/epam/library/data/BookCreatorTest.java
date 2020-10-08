package com.epam.library.data;

import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BookCreatorTest {
    private static final int EXPECTED_LIST_SIZE = 4;

    @Test
    public void testCreateBookListShouldCreateCorrectBookList() {
        BookCreator bookCreator = new BookCreator();
        String actualData = "Carrie,King S.,1976,Thriller\n" +
                "The Shining,King S.,1980,Thriller\n" +
                "A Game of Thrones,Martin G.,1996,Fantasy\n" +
                "A Feast for Crows,Martin G.,2005,Fantasy";
        List<Book> actualBookList = bookCreator.createBooksList(actualData);
        Assert.assertEquals(EXPECTED_LIST_SIZE, actualBookList.size());
    }
}
