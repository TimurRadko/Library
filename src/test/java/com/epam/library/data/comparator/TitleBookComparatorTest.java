package com.epam.library.data.comparator;

import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class TitleBookComparatorTest {
    private static final Book MAJOR_BOOK = new Book("B", "B", 1, "B");
    private static final Book MINOR_BOOK = new Book("A", "B", 1, "B");

    @Test
    public void testCompareShouldReturnCorrectAnswer() {
        Comparator<Book> comparator = new TitleBookComparator();
        int actualResult = comparator.compare(MAJOR_BOOK, MINOR_BOOK);
        Assert.assertEquals(1, actualResult);
    }
}
