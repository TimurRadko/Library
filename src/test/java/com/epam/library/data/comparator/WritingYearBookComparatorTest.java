package com.epam.library.data.comparator;

import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class WritingYearBookComparatorTest {
    private static final Book MAJOR_BOOK = new Book("B", "B", 2, "B");
    private static final Book MINOR_BOOK = new Book("B", "B", 1, "B");

    @Test
    public void testCompareShouldReturnCorrectAnswer() {
        BookComparator comparator = new WritingYearBookComparator();
        int actualResult = comparator.compare(MAJOR_BOOK, MINOR_BOOK);
        Assert.assertEquals(1, actualResult);
    }
}
