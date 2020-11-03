package com.epam.library.data;

import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class BookParserTest {
    private static final String VALID_LINE = "Carrie,King S.,1976,Thriller";
    private static final Book EXPECTED_BOOK = new Book("Carrie", "King S.", 1976, "Thriller");
    private static final String INVALID_LINE = "Carrie,King S.,Mistake,Thriller";

    @Test
    public void testCreateBookShouldCreateValidBookWhenDataIsValid() {
        BookParser parser = new BookParser();
        Book actualBook = parser.parse(VALID_LINE);
        Assert.assertEquals(EXPECTED_BOOK, actualBook);
    }

    @Test(expected = NumberFormatException.class)
    public void testCreateBookShouldThrowExceptionWhenDataIsInvalid() {
        BookParser parser = new BookParser();
        Book actualBook = parser.parse(INVALID_LINE);
    }
}
