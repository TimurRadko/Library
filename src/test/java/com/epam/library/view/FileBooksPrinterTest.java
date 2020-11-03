package com.epam.library.view;

import com.epam.library.data.BookDao;
import com.epam.library.data.factory.BookComparatorFactory;
import com.epam.library.data.factory.SpecificationFactory;
import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileBooksPrinterTest {
    private final List<Book> defaultBookList = new ArrayList<>(Arrays.asList(CARRIE_BOOK, THE_SHINING_BOOK));
    private static final Book CARRIE_BOOK = new Book("Carrie", "King S.", 1976, "Thriller");
    private static final Book THE_SHINING_BOOK = new Book("The Shining", "King S.", 1980, "Thriller");
    private BookDao actualDao;
    private static final String FILE_PATH = "src/test/resources/out-test.txt";
    private static final String INVALID_FILE_PATH = "src/test/resources/";

    @Before
    public void creatingDependencies() {
        SpecificationFactory specificationFactory = Mockito.mock(SpecificationFactory.class);
        BookComparatorFactory comparatorFactory = Mockito.mock(BookComparatorFactory.class);
        actualDao = new BookDao(defaultBookList, specificationFactory, comparatorFactory);
    }

    @Test
    public void testPrintShouldCorrectPrintWhenBookDaoNotEmpty() throws DataException {
        FileBooksPrinter printer = new FileBooksPrinter(FILE_PATH);
        printer.print(actualDao);
        String firstLine = getFirstBookToStringFromFile();
        String expectedLine = CARRIE_BOOK.toString();
        Assert.assertEquals(expectedLine, firstLine);
    }

    @Test(expected = DataException.class)
    public void testPrintShouldThrowDataExceptionWhenBookDaoNotEmpty() throws DataException {
        FileBooksPrinter printer = new FileBooksPrinter(INVALID_FILE_PATH);
        printer.print(actualDao);
    }

    private String getFirstBookToStringFromFile() throws DataException {
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
            line = reader.readLine();
        } catch (IOException e) {
            throw new DataException("File not found.", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }
}
