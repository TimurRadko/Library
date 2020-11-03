package com.epam.library.data.specification;

import com.epam.library.model.Book;

public class WritingYearSpecification extends AbstractSpecification<Integer> {

    @Override
    public boolean isFieldEqual(Book book, Integer value) {
        Integer writingYear = book.getWritingYear();
        return writingYear.equals(value);
    }
}
