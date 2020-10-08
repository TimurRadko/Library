package com.epam.library.data.specification;

import com.epam.library.Runner;
import com.epam.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpecification implements Specification {

    @Override
    public List<Book> find(List<Book> books, String value) {
        List<Book> findingBooks = new ArrayList<>();
        for (Book book : books) {
            String field = getField(book);
            if (field.equalsIgnoreCase(value)) {
                findingBooks.add(book);
            }
        }
        Runner.LOGGER.info(String.format("Searching Books by Tag is Ended. %d books found.", findingBooks.size()));
        return findingBooks;
    }

    abstract String getField(Book book);
}
