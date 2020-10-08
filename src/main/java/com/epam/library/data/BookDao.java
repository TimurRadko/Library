package com.epam.library.data;

import com.epam.library.Runner;
import com.epam.library.data.factory.BookComparatorFactory;
import com.epam.library.data.factory.BookComparatorFactoryImpl;
import com.epam.library.data.factory.SpecificationFactory;
import com.epam.library.data.factory.SpecificationFactoryImpl;
import com.epam.library.data.specification.Specification;
import com.epam.library.exception.DataException;
import com.epam.library.model.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDao {
    private final List<Book> booksList;

    public BookDao(List<Book> booksList) {
        this.booksList = booksList;
    }

    private int getBookDaoSize() {
        return booksList.size();
    }

    public void addBook(Book book) throws DataException {
        if (booksList.contains(book)) {
            String bookToString = prepareBooksToString(book);
            throw new DataException(String.format("\nThe book being added (%s) is in the library.\n", bookToString));
        }
        booksList.add(book);
        Runner.LOGGER.info(String.format("Adding Book is Ended. Current Library size is %d.", getBookDaoSize()));
    }

    public void removeBook(Book book) throws DataException {
        if (!booksList.contains(book)) {
            String bookToString = prepareBooksToString(book);
            throw new DataException(String.format("\nThe book being deleted (%s) is not in the library.\n", bookToString));
        }
        booksList.remove(book);
        Runner.LOGGER.info(String.format("Removing Book is Ended. Current Library size is %d.", getBookDaoSize()));
    }

    private String prepareBooksToString(Book book) {
        String bookToString = book.toString();
        int lastIndex = bookToString.length() - 1;
        return bookToString.substring(0, lastIndex);
    }

    public List<Book> findByTag(BooksField booksField, String value) {
        SpecificationFactory specificationFactory = new SpecificationFactoryImpl();
        Specification specification = specificationFactory.create(booksField);
        return specification.find(booksList, value);
    }

    public void sortBooksByTag(BooksField booksField) {
        BookComparatorFactory comparatorFactory = new BookComparatorFactoryImpl();
        Comparator<Book> comparator = comparatorFactory.create(booksField);
        Collections.sort(booksList, comparator);
        Runner.LOGGER.info("Sorting Books is Ended.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookDao bookDao = (BookDao) o;

        return booksList.equals(bookDao.booksList);
    }

    @Override
    public int hashCode() {
        return booksList.hashCode();
    }

    @Override
    public String toString() {
        return "\nNow in our bookshelves:\n" + getBooksList(booksList);
    }

    private String getBooksList(List<Book> booksList) {
        StringBuilder builder = new StringBuilder();
        for (Book book : booksList) {
            builder.append(book);
        }
        return builder.toString();
    }
}
