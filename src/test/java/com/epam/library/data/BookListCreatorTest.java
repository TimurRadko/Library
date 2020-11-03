package com.epam.library.data;

import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BookListCreatorTest {
    private static final int EXPECTED_LIST_SIZE = 4;
    private static final List<String> BOOK_LIST =
            Arrays.asList("Carrie,King S.,1976,Thriller",
                    "The Shining,King S.,1980,Thriller",
                    "A Game of Thrones,Martin G.,1996,Fantasy",
                    "A Feast for Crows,Martin G.,2005,Fantasy");
    private static final Book EXPECTED_BOOK = new Book("Carrie", "King S.", 1976, "Thriller");
    private static final int FIST_BOOK_INDEX = 0;
    private static final BookParser PARSER = new BookParser();

    @Test
    public void testCreateBookListShouldCreateCorrectBookList() throws DataException {
        BookListCreator bookListCreator = new BookListCreator(PARSER);
        List<Book> actualBookList = bookListCreator.createBooksList(BOOK_LIST);
        Book actualBook = actualBookList.get(FIST_BOOK_INDEX);
        Assert.assertEquals(EXPECTED_LIST_SIZE, actualBookList.size());
        Assert.assertEquals(EXPECTED_BOOK, actualBook);
    }

    @Test(expected = DataException.class)
    public void testCreateBookListShouldThrowDataExceptionWhenLInesNotExists() throws DataException {
        BookListCreator bookListCreator = new BookListCreator(PARSER);
        List<Book> actualBookList = bookListCreator.createBooksList(null);
    }
}
