package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.comparator.WritingYearBookComparator;
import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class BookComparatorFactoryImplTest {

    @Test
    public void testCreateShouldCreateComparator() {
        BookComparatorFactory factory = new BookComparatorFactoryImpl();
        Comparator<Book> comparator = factory.create(BooksField.WRITING_YEAR);
        Assert.assertNotNull(comparator);
        Assert.assertTrue(comparator instanceof WritingYearBookComparator);
    }
}
