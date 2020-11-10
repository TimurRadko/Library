package com.epam.library.data.comparator;

import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class GenreBookComparatorTest {
    private static final Book MAJOR_BOOK = new Book("B", "B", 1, "B");
    private static final Book MINOR_BOOK = new Book("B", "B", 1, "A");
    private static final Book BOOK_WITH_NULLABLE_FIELDS =
            new Book(null, null, 1, null);

    @Test
    public void testCompareShouldReturnCorrectAnswer() {
        Comparator<Book> comparator = new GenreBookComparator();
        int actualResult = comparator.compare(MAJOR_BOOK, MINOR_BOOK);
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void testCompareShouldReturnOneWhenFirstBookHasNullableFields() {
        Comparator<Book> comparator = new GenreBookComparator();
        int actualResult = comparator.compare(BOOK_WITH_NULLABLE_FIELDS, MINOR_BOOK);
        Assert.assertEquals(-1, actualResult);
    }

    @Test
    public void testCompareShouldReturnOneWhenSecondBookHasNullableFields() {
        Comparator<Book> comparator = new GenreBookComparator();
        int actualResult = comparator.compare(MINOR_BOOK, BOOK_WITH_NULLABLE_FIELDS);
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void testCompareShouldReturnZeroWhenBothBookHaveNullableFields() {
        Comparator<Book> comparator = new GenreBookComparator();
        int actualResult = comparator.compare(BOOK_WITH_NULLABLE_FIELDS, BOOK_WITH_NULLABLE_FIELDS);
        Assert.assertEquals(0, actualResult);
    }
}
