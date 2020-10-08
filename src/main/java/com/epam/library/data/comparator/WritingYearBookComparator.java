package com.epam.library.data.comparator;

import com.epam.library.model.Book;

public class WritingYearBookComparator extends AbstractBookComparator {

    @Override
    String getField(Book book) {
        int writingYear = book.getWritingYear();
        return String.valueOf(writingYear);
    }
}
