package com.epam.library.data;

import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookDaoTest {
    private static final Book CORRECT_ADDED_BOOK = new Book("1984", "Orwell G.", 1948, "Dystopian");
    private static final Book FAILED_ADDED_BOOK = new Book("Carrie", "King S.", 1976, "Thriller");
    private static final BookDao EXPECTED_BOOK_DAO_FOR_ADD =
            new BookDao(Arrays.asList(new Book("Carrie", "King S.", 1976, "Thriller"),
                    new Book("The Shining", "King S.", 1980, "Thriller"),
                    new Book("1984", "Orwell G.", 1948, "Dystopian")));

    private static final Book CORRECT_REMOVED_BOOK = new Book("Carrie", "King S.", 1976, "Thriller");
    private static final Book FAILED_REMOVED_BOOK = new Book("1984", "Orwell G.", 1948, "Dystopian");
    private static final BookDao EXPECTED_BOOK_DAO_FOR_REMOVE =
            new BookDao(Collections.singletonList(new Book("The Shining", "King S.", 1980, "Thriller")));

    private static final String SEARCH_AUTHOR = "King S.";
    private static final BookDao EXPECTED_SEARCHING_BOOK_DAO =
            new BookDao(Arrays.asList(new Book("Carrie", "King S.", 1976, "Thriller"),
                    new Book("The Shining", "King S.", 1980, "Thriller")));

    private static final BookDao EXPECTED_EMPTY_DAO = new BookDao(new ArrayList<Book>());
    private static final String NOT_EXIST_AUTHOR = "Pancake";

    private static final String EXPECTED_SORTED_LIST =
            "\nNow in our bookshelves:\n\"Carrie\", King S., 1976, Genre: Thriller\n" +
            "\"The Shining\", King S., 1980, Genre: Thriller\n";

    private BookDao actualDao;

    @Before
    public void createActualDao() {
        List<Book> actualList = createBooksList();
        actualDao = new BookDao(actualList);
    }

    @Test
    public void testAddBookShouldAddWhenBookIsNotListed() throws DataException {
        actualDao.addBook(CORRECT_ADDED_BOOK);
        Assert.assertEquals(EXPECTED_BOOK_DAO_FOR_ADD, actualDao);
    }

    @Test(expected = DataException.class)
    public void testAddBookShouldThrowExceptionWhenBookIsListed() throws DataException {
        actualDao.addBook(FAILED_ADDED_BOOK);
    }

    @Test
    public void testRemoveBookShouldRemoveWhenBookIsListed() throws DataException {
        actualDao.removeBook(CORRECT_REMOVED_BOOK);
        Assert.assertEquals(EXPECTED_BOOK_DAO_FOR_REMOVE, actualDao);
    }

    @Test(expected = DataException.class)
    public void testRemoveBookShouldThrowExceptionWhenBookIsNotListed() throws DataException {
        actualDao.removeBook(FAILED_REMOVED_BOOK);
    }

    @Test
    public void testFindByTagShouldFindCorrectListWhenAuthorExists() throws DataException {
        List<Book> findByAuthor = actualDao.findByTag(BooksField.AUTHOR_NAME, SEARCH_AUTHOR);
        BookDao findingActualDao = new BookDao(findByAuthor);
        Assert.assertEquals(EXPECTED_SEARCHING_BOOK_DAO, findingActualDao);
    }

    @Test
    public void testFindByTagShouldReturnEmptyListWhenAuthorNotExists() throws DataException {
        List<Book> findByAuthor = actualDao.findByTag(BooksField.AUTHOR_NAME, NOT_EXIST_AUTHOR);
        BookDao findingActualDao = new BookDao(findByAuthor);
        Assert.assertEquals(EXPECTED_EMPTY_DAO, findingActualDao);
    }

    @Test
    public void testSortBooksByTagShouldReturnSortStructure() {
        actualDao.sortBooksByTag(BooksField.WRITING_YEAR);
        String stringActualDao = actualDao.toString();
        Assert.assertEquals(EXPECTED_SORTED_LIST, stringActualDao);
    }

    private List<Book> createBooksList() {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Carrie", "King S.", 1976, "Thriller"));
        booksList.add(new Book("The Shining", "King S.", 1980, "Thriller"));
        return booksList;
    }
}
