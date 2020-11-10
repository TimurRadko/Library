package com.epam.library.data;

import com.epam.library.data.factory.BookComparatorFactory;
import com.epam.library.data.factory.SpecificationFactory;
import com.epam.library.data.specification.Specification;
import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDao {
    private static final Logger LOGGER = LogManager.getLogger(BookDao.class);
    private final List<Book> booksList;
    private final SpecificationFactory specificationFactory;
    private final BookComparatorFactory comparatorFactory;

    public BookDao(List<Book> booksList,
                   SpecificationFactory specificationFactory,
                   BookComparatorFactory comparatorFactory) {
        this.booksList = booksList;
        this.specificationFactory = specificationFactory;
        this.comparatorFactory = comparatorFactory;
    }

    public Book get(int index) {
        return booksList.get(index);
    }

    public void add(Book book) throws DataException {
        if (booksList.contains(book)) {
            throw new DataException(String.format("\nThe book being added (%s) is in the library.\n",
                    prepareBooksToString(book)));
        }
        booksList.add(book);
        LOGGER.info(String.format("Adding Book is Ended. Current Library size is %d.", size()));
    }

    public void remove(Book book) throws DataException {
        if (!booksList.contains(book)) {
            throw new DataException(String.format("\nThe book being deleted (%s) is not in the library.\n",
                    prepareBooksToString(book)));
        }
        booksList.remove(book);
        LOGGER.info(String.format("Removing Book is Ended. Current Library size is %d.", size()));
    }

    public <T> List<Book> findByTag(BooksField booksField, T value) throws DataException {
        Specification<T> specification = specificationFactory.create(booksField);
        return specification.find(booksList, value);
    }

    public List<Book> sortBooksByTag(BooksField booksField) {
        Comparator<Book> comparator = comparatorFactory.create(booksField);
        Collections.sort(booksList, comparator);
        LOGGER.info("Sorting Books is Ended.");
        return booksList;
    }

    public int size() {
        return booksList.size();
    }

    private String prepareBooksToString(Book book) {
        String bookToString = book.toString();
        int lastIndex = bookToString.length() - 1;
        return bookToString.substring(0, lastIndex);
    }
}
