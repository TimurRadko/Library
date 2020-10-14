package com.epam.library.data.specification;

import com.epam.library.exception.DataException;
import com.epam.library.model.Book;

public class TitleSpecification<T> extends AbstractSpecification<T> {

    @Override
    boolean isFieldEqual(Book book, T value) throws DataException {
        String title = book.getTitle();

        if (value instanceof String) {
            String stringValue = (String) value;
            return title.equalsIgnoreCase(stringValue);
        } else {
            throw new DataException("Invalid input value");
        }
    }
}
