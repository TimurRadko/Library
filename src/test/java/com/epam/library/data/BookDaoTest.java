package com.epam.library.data;

import com.epam.library.data.factory.BookComparatorFactory;
import com.epam.library.data.factory.BookComparatorFactoryImpl;
import com.epam.library.data.factory.SpecificationFactory;
import com.epam.library.data.factory.SpecificationFactoryImpl;
import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDaoTest {
    private final List<Book> defaultBookList = new ArrayList<>(Arrays.asList(CARRIE_BOOK, THE_SHINING_BOOK));
    private static final Book CARRIE_BOOK = new Book("Carrie", "King S.", 1976, "Thriller");
    private static final Book THE_SHINING_BOOK = new Book("The Shining", "King S.", 1980, "Thriller");
    private static final Book EIGHTEEN_EIGHTY_FOUR = new Book("1984", "Orwell G.", 1948, "Dystopian");
    private static final int EXPECTED_DAO_SIZE_ADD_TESTS = 3;
    private static final int EXPECTED_DAO_SIZE_REMOVE_TESTS = 1;
    private static final int EXPECTED_DAO_SIZE_FIND_TESTS = 2;
    private static final int ZERO_SIZE_LIST = 0;
    private static final int INDEX_FIRST_DAO_BOOK = 0;
    private BookDao actualDao;
    private static final String KING_S = "King S.";
    private static final String ORWELL_G = "Orwell G.";

    @Before
    public void injectingDependencies() {
        SpecificationFactory specificationFactory = Mockito.mock(SpecificationFactory.class);
        BookComparatorFactory comparatorFactory = Mockito.mock(BookComparatorFactory.class);
        actualDao = new BookDao(defaultBookList, specificationFactory, comparatorFactory);
    }

    @Test
    public void testAddBookShouldAddWhenBookIsNotListed() throws DataException {
        actualDao.add(EIGHTEEN_EIGHTY_FOUR);
        int actualDaoSize = actualDao.size();
        Book actualBook = actualDao.get(2);
        Assert.assertEquals(EXPECTED_DAO_SIZE_ADD_TESTS, actualDaoSize);
        Assert.assertEquals(EIGHTEEN_EIGHTY_FOUR, actualBook);
    }

    @Test(expected = DataException.class)
    public void testAddBookShouldThrowDataExceptionWhenBookIsListed() throws DataException {
        actualDao.add(CARRIE_BOOK);
    }

    @Test
    public void testRemoveBookShouldRemoveWhenBookIsListed() throws DataException {
        actualDao.remove(THE_SHINING_BOOK);
        Book actualBook = actualDao.get(INDEX_FIRST_DAO_BOOK);
        Assert.assertEquals(EXPECTED_DAO_SIZE_REMOVE_TESTS, actualDao.size());
        Assert.assertEquals(CARRIE_BOOK, actualBook);
    }

    @Test(expected = DataException.class)
    public void testRemoveBookShouldThrowExceptionWhenBookIsNotListed() throws DataException {
        actualDao.remove(EIGHTEEN_EIGHTY_FOUR);
    }

    @Test
    public void testFindByTagShouldFindCorrectListWhenAuthorExists() throws DataException {
        SpecificationFactory specificationFactory = new SpecificationFactoryImpl();
        BookComparatorFactory comparatorFactory = new BookComparatorFactoryImpl();
        BookDao actualDao = new BookDao(defaultBookList, specificationFactory, comparatorFactory);
        List<Book> findByAuthorList = actualDao.findByTag(BooksField.AUTHOR_NAME, KING_S);
        Book actualBook = findByAuthorList.get(INDEX_FIRST_DAO_BOOK);
        Assert.assertEquals(EXPECTED_DAO_SIZE_FIND_TESTS, findByAuthorList.size());
        Assert.assertEquals(CARRIE_BOOK, actualBook);
    }

    @Test
    public void testFindByTagShouldReturnEmptyListWhenAuthorNotExists() throws DataException {
        SpecificationFactory specificationFactory = new SpecificationFactoryImpl();
        BookComparatorFactory comparatorFactory = new BookComparatorFactoryImpl();
        BookDao actualDao = new BookDao(defaultBookList, specificationFactory, comparatorFactory);
        List<Book> findByAuthorList = actualDao.findByTag(BooksField.AUTHOR_NAME, ORWELL_G);
        Assert.assertEquals(ZERO_SIZE_LIST, findByAuthorList.size());
    }

    @Test
    public void testSortBooksByTagShouldReturnSortStructure() {
        SpecificationFactory specificationFactory = new SpecificationFactoryImpl();
        BookComparatorFactory comparatorFactory = new BookComparatorFactoryImpl();
        BookDao actualDao = new BookDao(defaultBookList, specificationFactory, comparatorFactory);
        List<Book> sortedBookList = actualDao.sortBooksByTag(BooksField.WRITING_YEAR);
        Book actualFirstBook = sortedBookList.get(INDEX_FIRST_DAO_BOOK);
        Assert.assertEquals(CARRIE_BOOK, actualFirstBook);
    }
}
