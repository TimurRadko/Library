package com.epam.library.data.specification;

import com.epam.library.exception.DataException;
import com.epam.library.model.Book;

public class AuthorNameSpecification<T> extends AbstractSpecification<T> {

    @Override
    boolean isFieldEqual(Book book, T value) throws DataException {
        String authorName = book.getAuthorName();

        if (value instanceof String) {
            String stringValue = (String) value;
            return authorName.equalsIgnoreCase(stringValue);
        } else {
            throw new DataException("Invalid input value");
        }
    }
}
