package com.epam.library.data.specification;

import com.epam.library.exception.DataException;
import com.epam.library.model.Book;

public class WritingYearSpecification<T> extends AbstractSpecification<T> {

    @Override
    boolean isFieldEqual(Book book, T value) throws DataException {
        Integer writingYear = book.getWritingYear();

        if (value instanceof Integer) {
            Integer intValue = (Integer) value;
            return writingYear.equals(intValue);
        } else {
            throw new DataException("Invalid input value");
        }
    }
}
