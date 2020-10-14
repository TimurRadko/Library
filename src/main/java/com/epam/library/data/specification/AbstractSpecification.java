package com.epam.library.data.specification;

import com.epam.library.Runner;
import com.epam.library.exception.DataException;
import com.epam.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpecification<T> implements Specification<T> {

    abstract boolean isFieldEqual(Book book, T value) throws DataException;

    @Override
    public List<Book> find(List<Book> books, T value) throws DataException {
        List<Book> findingBooks = new ArrayList<>();
        for (Book book : books) {
            if (isFieldEqual(book, value)) {
                findingBooks.add(book);
            }
        }
        Runner.LOGGER.info(String.format("Searching Books by Tag is Ended. %d books found.", findingBooks.size()));
        return findingBooks;
    }
}
