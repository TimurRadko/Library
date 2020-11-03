package com.epam.library.data.comparator;

import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class AuthorNameBookComparatorTest {
    private static final Book MAJOR_BOOK = new Book("B", "B", 1, "B");
    private static final Book MINOR_BOOK = new Book("B", "A", 1, "B");

    @Test
    public void testCompareShouldReturnCorrectAnswer() {
        Comparator<Book> comparator = new AuthorNameBookComparator();
        int actualResult = comparator.compare(MAJOR_BOOK, MINOR_BOOK);
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void testCompareShouldReturnOneWhenFirstBookIsNull() {
        Comparator<Book> comparator = new AuthorNameBookComparator();
        int actualResult = comparator.compare(null, MINOR_BOOK);
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void testCompareShouldReturnOneWhenSecondBookIsNull() {
        Comparator<Book> comparator = new AuthorNameBookComparator();
        int actualResult = comparator.compare(MINOR_BOOK, null);
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void testCompareShouldReturnZeroWhenBothBookIsNull() {
        Comparator<Book> comparator = new AuthorNameBookComparator();
        int actualResult = comparator.compare(null, null);
        Assert.assertEquals(0, actualResult);
    }
}
