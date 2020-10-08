package com.epam.library.data.specification;

import com.epam.library.model.Book;

public class WritingYearSpecification extends AbstractSpecification {

    @Override
    String getField(Book book) {
        int writingYear = book.getWritingYear();
        return String.valueOf(writingYear);
    }
}
